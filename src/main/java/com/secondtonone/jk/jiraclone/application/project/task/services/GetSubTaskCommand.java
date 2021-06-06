package com.secondtonone.jk.jiraclone.application.project.task.services;

import com.secondtonone.jk.jiraclone.application.project.task.controllers.SubTaskViewDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

import java.util.stream.Collectors;

import static com.secondtonone.jk.jiraclone.application.helpers.LoggedTimeHelper.countLoggedTime;


public class GetSubTaskCommand {
    private final TaskRepository taskRepository;

    public GetSubTaskCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<SubTaskViewDto> execute(String key) {
        return taskRepository.findByMainTaskKey(key).stream().map(
                task -> SubTaskViewDto.builder()
                        .withId(task.getId())
                        .withKey(task.getKey())
                        .withSummary(task.getSummary())
                        .withPriority(task.getPriority())
                        .withType(task.getType())
                        .withAssigneeId(task.getAssignee().getId())
                        .withLoggedTime(countLoggedTime(task) + "/" + task.getEstimatedTime())
                        .build()
        ).collect(Collectors.toSet());

    }
}
