package com.secondtonone.jk.jiraclone.application.task.commands;

public class ReleaseNotFoundException extends RuntimeException {
    public ReleaseNotFoundException(String message) {
        super(message);
    }
}
