package com.secondtonone.jk.jiraclone.rest.api.project.project.exceptions;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
