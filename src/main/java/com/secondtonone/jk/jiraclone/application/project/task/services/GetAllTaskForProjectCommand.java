package com.secondtonone.jk.jiraclone.application.project.task.services;

import com.secondtonone.jk.jiraclone.application.project.task.dto.SimpleTaskViewDto;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Status;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ProjectRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

import java.util.UUID;
import java.util.stream.Collectors;

public class GetAllTaskForProjectCommand {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public GetAllTaskForProjectCommand(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public Iterable<SimpleTaskViewDto> execute(UUID projectId) {
        return taskRepository.findByKeyContainsAndStatusNotOrderByKeyAsc(projectRepository.findById(projectId)
                        .orElseThrow(() -> new ProjectNotFoundException("project not found"))
                        .getCode(),
                Status.CLOSED)
                .stream().map(SimpleTaskViewDto::buildDto)
                .collect(Collectors.toList());
    }
}
