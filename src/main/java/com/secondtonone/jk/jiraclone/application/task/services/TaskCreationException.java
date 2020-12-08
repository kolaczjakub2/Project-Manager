package com.secondtonone.jk.jiraclone.application.task.services;

public class TaskCreationException extends RuntimeException {
    public TaskCreationException(Exception e) {
        super(e);
    }
}
