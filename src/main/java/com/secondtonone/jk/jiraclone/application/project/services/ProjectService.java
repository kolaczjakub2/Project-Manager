package com.secondtonone.jk.jiraclone.application.project.services;

import com.secondtonone.jk.jiraclone.application.project.commands.GetAllProjectCommand;
import com.secondtonone.jk.jiraclone.application.project.dto.SelectProjectDto;

public class ProjectService {
    private final GetAllProjectCommand getAllProjectCommand;

    public ProjectService(GetAllProjectCommand getAllProjectCommand) {
        this.getAllProjectCommand = getAllProjectCommand;
    }

    public Iterable<SelectProjectDto> getAllProjects() {
        return getAllProjectCommand.execute();
    }
}
