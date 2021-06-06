package com.secondtonone.jk.jiraclone.application.project.task.commands;

import com.secondtonone.jk.jiraclone.application.project.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.application.users.exceptions.UserNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.Release;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.application.project.task.dto.CreateTaskRequestDto;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Resolution;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Status;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ReleaseRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;

public class CreateTaskCommand {
    private final TaskRepository taskRepository;
    private final UserAccountRepository userAccountRepository;
    private final ReleaseRepository releaseRepository;

    public CreateTaskCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository, ReleaseRepository releaseRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
        this.releaseRepository = releaseRepository;
    }


    public Task execute(CreateTaskRequestDto dto) {
        Task.Builder builder = Task.builder()
                .withSummary(dto.getSummary())
                .withDescription(dto.getDescription())
                .withEstimatedTime(dto.getEstimatedTime())
                .withStatus(Status.OPEN)
                .withResolution(Resolution.NONE)
                .withPriority(dto.getPriority())
                .withTaskType(dto.getTaskType())
                .withKey(createTaskKey(releaseRepository.findById(dto.getReleaseId()).orElseThrow(() -> new ReleaseNotFoundException("Release not found"))))
                .withCreator(userAccountRepository.findById(dto.getAssigneeId()).orElseThrow(() -> new UserNotFoundException("User not found")))
                .withAssignee(userAccountRepository.findById(dto.getAssigneeId()).orElseThrow(() -> new UserNotFoundException("User not found")))
                .withRelease(releaseRepository.findById(dto.getReleaseId()).orElseThrow(() -> new ReleaseNotFoundException("Release not found")));


        if (dto.getMainTaskKey() != null) {
            builder.withMainTask(taskRepository.findByKey(dto.getMainTaskKey()).orElseThrow(() -> new TaskNotFoundException("Task not found")));
        }

        Task toSave = builder.build();

        return taskRepository.save(toSave);
    }

    private String createTaskKey(Release release) {
        String projectCode = releaseRepository.getProjectCode(release.getId());
        long number = taskRepository.count();
        return projectCode + "-" + number;
    }
}
