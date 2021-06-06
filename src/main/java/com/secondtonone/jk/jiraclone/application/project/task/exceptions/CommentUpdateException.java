package com.secondtonone.jk.jiraclone.application.project.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CommentUpdateException extends RuntimeException {
    public CommentUpdateException(String message) {
        super(message);
    }
}
