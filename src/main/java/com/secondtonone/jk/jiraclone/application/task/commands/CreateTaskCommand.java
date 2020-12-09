package com.secondtonone.jk.jiraclone.application.task.commands;

import com.secondtonone.jk.jiraclone.application.task.services.TaskCreationException;
import com.secondtonone.jk.jiraclone.domain.task.Task;
import com.secondtonone.jk.jiraclone.domain.task.dto.CreateTaskRequestDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.ReleaseRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.UserAccountRepository;

public class CreateTaskCommand {
    private final TaskRepository taskRepository;
    private final UserAccountRepository userAccountRepository;
    private final ReleaseRepository releaseRepository;

    public CreateTaskCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository, ReleaseRepository releaseRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
        this.releaseRepository = releaseRepository;
    }


    public Boolean execute(CreateTaskRequestDto dto) {
        try {
            Task toSave = Task.builder()
                    .withSummary(dto.getSummary())
                    .withDescription(dto.getDescription())
                    .withEstimatedTime(dto.getEstimatedTime())
                    .withCreator(userAccountRepository.findById(dto.getCreatorId()).orElse(null))
                    .withAssignee(userAccountRepository.findById(dto.getAssigneeId()).orElse(null))
                    .withRelease(releaseRepository.findById(dto.getReleaseId()).orElse(null))
                    .build();

            taskRepository.save(toSave);
            return true;
        } catch (Exception e) {
            throw new TaskCreationException(e);
        }
    }
}
