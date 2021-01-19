package com.secondtonone.jk.jiraclone.application.project.commands;

import com.secondtonone.jk.jiraclone.application.project.dto.SelectProjectDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.ProjectRepository;

import java.util.stream.Collectors;

public class GetAllProjectCommand {
    private final ProjectRepository projectRepository;

    public GetAllProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Iterable<SelectProjectDto> execute() {
        return projectRepository.findAll().stream().map(project -> SelectProjectDto.builder()
                .withCode(project.getCode())
                .withDescription(project.getDescription())
                .withName(project.getName())
                .withProjectId(project.getId())
                .build()).collect(Collectors.toSet());
    }
}
