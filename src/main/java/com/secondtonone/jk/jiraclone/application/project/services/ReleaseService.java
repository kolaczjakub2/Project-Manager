package com.secondtonone.jk.jiraclone.application.project.services;

import com.secondtonone.jk.jiraclone.application.project.commands.GetAllReleasesCommand;
import com.secondtonone.jk.jiraclone.application.project.dto.SelectReleaseDto;

import java.util.UUID;

public class ReleaseService {

    private final GetAllReleasesCommand getAllReleasesCommand;

    public ReleaseService(GetAllReleasesCommand getAllReleasesCommand) {
        this.getAllReleasesCommand = getAllReleasesCommand;
    }


    public Iterable<SelectReleaseDto> getAllReleases(UUID projectId) {
        return this.getAllReleasesCommand.execute(projectId);
    }
}

