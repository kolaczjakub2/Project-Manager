package com.secondtonone.jk.jiraclone.application.project.task.commands;

import com.secondtonone.jk.jiraclone.application.project.task.exceptions.CommentNotFound;
import com.secondtonone.jk.jiraclone.application.project.task.exceptions.CommentUpdateException;
import com.secondtonone.jk.jiraclone.domain.project.task.Comment;
import com.secondtonone.jk.jiraclone.application.project.task.dto.UpdateCommentDto;
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
