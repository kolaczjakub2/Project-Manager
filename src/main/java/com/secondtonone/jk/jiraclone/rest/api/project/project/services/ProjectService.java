package com.secondtonone.jk.jiraclone.rest.api.project.project.services;

import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetAllProjectCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetAllTaskForProjectCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.project.dto.SelectProjectDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.SimpleTaskViewDto;

import java.util.UUID;

public class ProjectService {
    private final GetAllProjectCommand getAllProjectCommand;
    private final GetAllTaskForProjectCommand getAllTasksForProject;

    public ProjectService(GetAllProjectCommand getAllProjectCommand, GetAllTaskForProjectCommand getAllTasksForProject) {
        this.getAllProjectCommand = getAllProjectCommand;
        this.getAllTasksForProject = getAllTasksForProject;
    }

    public Iterable<SelectProjectDto> getAllProjects() {
        return getAllProjectCommand.execute();
    }

    public Iterable<SimpleTaskViewDto> getAllTasksForProject(UUID projectId) {
        return getAllTasksForProject.execute(projectId);
    }
}
