package com.secondtonone.jk.jiraclone.rest.api.project.project.commands;

import com.secondtonone.jk.jiraclone.rest.api.project.project.dto.SelectProjectDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ProjectRepository;

import java.util.stream.Collectors;

public class GetAllProjectCommand {
    private final ProjectRepository projectRepository;

    public GetAllProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Iterable<SelectProjectDto> execute() {
        return projectRepository.findAll()
                .stream()
                .map(SelectProjectDto::of)
                .collect(Collectors.toSet());
    }
}
