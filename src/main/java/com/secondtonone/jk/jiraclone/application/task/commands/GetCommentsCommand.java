package com.secondtonone.jk.jiraclone.application.task.commands;

import com.secondtonone.jk.jiraclone.domain.task.dto.CommentDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.CommentRepository;

import java.util.stream.Collectors;

public class GetCommentsCommand {

    private final CommentRepository commentRepository;

    public GetCommentsCommand(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Iterable<CommentDto> execute(String key) {
        return this.commentRepository.findAllByTaskKeyOrderByCreatedDateAsc(key).stream()
                .map(comment -> CommentDto.builder()
                        .withId(comment.getId())
                        .withContent(comment.getContent())
                        .withUserId(comment.getAuthor().getId())
                        .withIsEdited(comment.getEdited())
                        .withCreatedDate(comment.getCreatedDate())
                        .build())
                .collect(Collectors.toList());
    }
}
