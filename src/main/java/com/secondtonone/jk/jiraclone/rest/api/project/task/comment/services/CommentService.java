package com.secondtonone.jk.jiraclone.rest.api.project.task.comment.services;

import com.secondtonone.jk.jiraclone.domain.project.task.Comment;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.commands.AddCommentCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.commands.GetCommentsCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.commands.UpdateCommentCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.dto.CommentDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.dto.CreateCommentRequestDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.UpdateCommentDto;

import java.util.Optional;
import java.util.UUID;

public class CommentService {

    private final AddCommentCommand addCommentCommand;
    private final GetCommentsCommand getCommentsCommand;
    private final UpdateCommentCommand updateCommentCommand;

    public CommentService(AddCommentCommand addCommentCommand, GetCommentsCommand getCommentsCommand, UpdateCommentCommand updateCommentCommand) {
        this.addCommentCommand = addCommentCommand;
        this.getCommentsCommand = getCommentsCommand;
        this.updateCommentCommand = updateCommentCommand;
    }

    public Optional<Comment> addComment(CreateCommentRequestDto dto, String key) {
        var saved = addCommentCommand.execute(dto, key);
        return Optional.of(saved);
    }

    public Iterable<CommentDto> getComments(String key) {
        return this.getCommentsCommand.execute(key);
    }

    public Optional<Comment> updateComment(UpdateCommentDto dto, UUID commentId) {
        var saved = updateCommentCommand.execute(dto, commentId);
        return Optional.of(saved);
    }
}
