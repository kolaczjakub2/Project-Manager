package com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.TaskDetailsDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

import static com.secondtonone.jk.jiraclone.rest.api.helpers.LoggedTimeHelper.countLoggedTime;

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
                .withVoters(task.getVoters().size())
                .withWatchers(task.getWatchers().size())
                .build();
    }
}
