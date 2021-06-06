package com.secondtonone.jk.jiraclone.application.project.task.commands;

public class ReleaseNotFoundException extends RuntimeException {
    public ReleaseNotFoundException(String message) {
        super(message);
    }
}
