package com.secondtonone.jk.jiraclone.rest.api.project.release.exceptions;

public class ReleaseNotFoundException extends RuntimeException {
    public ReleaseNotFoundException(String message) {
        super(message);
    }
}
