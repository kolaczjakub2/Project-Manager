package com.secondtonone.jk.jiraclone.application.task.services;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
