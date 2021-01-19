package com.secondtonone.jk.jiraclone.application.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommentNotFound extends RuntimeException {
    public CommentNotFound(String message) {
        super(message);
    }
}
