package com.secondtonone.jk.jiraclone.application.task.commands;

import com.secondtonone.jk.jiraclone.application.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.domain.task.Task;
import com.secondtonone.jk.jiraclone.domain.task.dto.TaskDetailsDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.TaskRepository;

import static com.secondtonone.jk.jiraclone.application.helpers.LoggedTimeHelper.countLoggedTime;

public class GetTaskByKeyCommand {
    private final TaskRepository taskRepository;

    public GetTaskByKeyCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDetailsDto execute(String key) {
        Task task = taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found"));

        return TaskDetailsDto.builder()
                .withKey(task.getKey())
                .withSummary(task.getSummary())
                .withDescription(task.getDescription())
                .withEstimatedTime(task.getEstimatedTime())
                .withCreatedDate(task.getCreatedDate())
                .withLastModifiedDate(task.getLastModifiedDate())
                .withLoggedTime(countLoggedTime(task))
                .withStatus(task.getStatus())
                .withResolution(task.getResolution())
                .withTaskType(task.getType())
                .withPriority(task.getPriority())
                .withAssigneeId(task.getAssignee().getId())
                .withCreatorId(task.getCreator().getId())
                .withProjectId(task.getRelease().getProject().getId())
                .withReleaseId(task.getRelease().getId())
                .withMainTask(task.getMainTask())
                .build();
    }
}
