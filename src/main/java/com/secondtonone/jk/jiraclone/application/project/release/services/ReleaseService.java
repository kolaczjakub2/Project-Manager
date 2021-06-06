package com.secondtonone.jk.jiraclone.application.project.release.services;

import com.secondtonone.jk.jiraclone.application.project.project.commands.GetAllReleasesCommand;
import com.secondtonone.jk.jiraclone.application.project.release.dto.SelectReleaseDto;

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

