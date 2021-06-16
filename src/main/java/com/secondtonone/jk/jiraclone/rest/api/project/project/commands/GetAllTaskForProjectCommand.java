package com.secondtonone.jk.jiraclone.rest.api.project.project.commands;

import com.secondtonone.jk.jiraclone.domain.project.repositories.ProjectRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Status;
import com.secondtonone.jk.jiraclone.rest.api.project.project.exceptions.ProjectNotFoundException;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.SimpleTaskViewDto;

import java.util.stream.Collectors;

public class GetAllTaskForProjectCommand {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public GetAllTaskForProjectCommand(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public Iterable<SimpleTaskViewDto> execute(String projectCode) {
        return taskRepository.findByKeyContainsAndStatusNotOrderByKeyAsc(projectRepository.findByCode(projectCode)
                        .orElseThrow(() -> new ProjectNotFoundException("project not found"))
                        .getCode(),
                Status.CLOSED)
                .stream().map(SimpleTaskViewDto::buildDto)
                .collect(Collectors.toList());
    }
}
