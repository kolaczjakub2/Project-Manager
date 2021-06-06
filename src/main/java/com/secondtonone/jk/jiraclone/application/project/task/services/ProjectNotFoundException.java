package com.secondtonone.jk.jiraclone.application.project.task.services;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
