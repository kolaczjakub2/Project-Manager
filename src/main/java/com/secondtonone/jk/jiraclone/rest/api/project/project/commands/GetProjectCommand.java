package com.secondtonone.jk.jiraclone.rest.api.project.project.commands;

import com.secondtonone.jk.jiraclone.domain.project.repositories.ProjectRepository;
import com.secondtonone.jk.jiraclone.rest.api.project.project.dto.SelectProjectDto;
import com.secondtonone.jk.jiraclone.rest.api.project.project.exceptions.ProjectNotFoundException;

public class GetProjectCommand {

    private final ProjectRepository projectRepository;

    public GetProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public SelectProjectDto execute(String projectCode) {
        var project = projectRepository.findByCode(projectCode).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        return SelectProjectDto.of(project);
    }
}
