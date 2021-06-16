package com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class TaskCreationException extends RuntimeException {
    public TaskCreationException(String message) {
        super(message);
    }
}
