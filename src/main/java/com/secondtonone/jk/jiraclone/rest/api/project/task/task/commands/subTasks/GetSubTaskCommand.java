package com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.subTasks;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.SubTaskViewDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

import java.util.stream.Collectors;

import static com.secondtonone.jk.jiraclone.rest.api.helpers.LoggedTimeHelper.countLoggedTime;


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
