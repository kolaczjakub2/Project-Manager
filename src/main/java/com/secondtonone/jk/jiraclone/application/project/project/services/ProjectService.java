package com.secondtonone.jk.jiraclone.application.project.project.services;

import com.secondtonone.jk.jiraclone.application.project.release.commands.GetAllProjectCommand;
import com.secondtonone.jk.jiraclone.application.project.project.dto.SelectProjectDto;

public class ProjectService {
    private final GetAllProjectCommand getAllProjectCommand;

    public ProjectService(GetAllProjectCommand getAllProjectCommand) {
        this.getAllProjectCommand = getAllProjectCommand;
    }

    public Iterable<SelectProjectDto> getAllProjects() {
        return getAllProjectCommand.execute();
    }
}
