package com.secondtonone.jk.jiraclone.rest.api.project.project.services;

import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetAllProjectCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetAllTaskForProjectCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetProjectCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.project.dto.SelectProjectDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.SimpleTaskViewDto;

public class ProjectService {
    private final GetAllProjectCommand getAllProjectCommand;
    private final GetAllTaskForProjectCommand getAllTasksForProject;
    private final GetProjectCommand getProjectCommand;

    public ProjectService(GetAllProjectCommand getAllProjectCommand, GetAllTaskForProjectCommand getAllTasksForProject, GetProjectCommand getProjectCommand) {
        this.getAllProjectCommand = getAllProjectCommand;
        this.getAllTasksForProject = getAllTasksForProject;
        this.getProjectCommand = getProjectCommand;
    }

    public Iterable<SelectProjectDto> getAllProjects() {
        return getAllProjectCommand.execute();
    }

    public Iterable<SimpleTaskViewDto> getAllTasksForProject(String projectCode) {
        return getAllTasksForProject.execute(projectCode);
    }

    public SelectProjectDto getProject(String projectCode) {
        return getProjectCommand.execute(projectCode);
    }
}
