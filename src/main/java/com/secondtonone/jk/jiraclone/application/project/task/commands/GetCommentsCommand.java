package com.secondtonone.jk.jiraclone.application.project.task.commands;

import com.secondtonone.jk.jiraclone.application.project.task.dto.CommentDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.CommentRepository;

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
