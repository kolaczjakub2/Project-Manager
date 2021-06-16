package com.secondtonone.jk.jiraclone.rest.api.project.task.comment.commands;

import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.exceptions.CommentNotFound;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.exceptions.CommentUpdateException;
import com.secondtonone.jk.jiraclone.domain.project.task.Comment;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.UpdateCommentDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.CommentRepository;

import java.util.UUID;

public class UpdateCommentCommand {
    private final CommentRepository commentRepository;

    public UpdateCommentCommand(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment execute(UpdateCommentDto dto, UUID commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFound("Comment not found"));

        if (dto.getContent() == null) {
            throw new CommentUpdateException("Comment should contains content");
        }

        comment.setContent(dto.getContent());
        comment.setEdited(Boolean.TRUE);
        return commentRepository.save(comment);
    }
}
