package com.secondtonone.jk.jiraclone.rest.api.project.task.comment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CommentUpdateException extends RuntimeException {
    public CommentUpdateException(String message) {
        super(message);
    }
}
