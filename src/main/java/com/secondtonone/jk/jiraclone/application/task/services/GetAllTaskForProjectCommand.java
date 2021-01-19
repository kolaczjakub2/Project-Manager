package com.secondtonone.jk.jiraclone.application.task.services;

import com.secondtonone.jk.jiraclone.domain.task.dto.SimpleTaskViewDto;
import com.secondtonone.jk.jiraclone.domain.task.enums.Status;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.ProjectRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.TaskRepository;

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
