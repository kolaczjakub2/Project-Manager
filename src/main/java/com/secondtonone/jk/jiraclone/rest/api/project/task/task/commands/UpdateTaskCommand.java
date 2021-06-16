package com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.rest.api.users.exceptions.UserNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.UpdateTaskRequestDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;

public class UpdateTaskCommand {
    private final TaskRepository taskRepository;
    private final UserAccountRepository userAccountRepository;

    public UpdateTaskCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public Task execute(UpdateTaskRequestDto dto, String key) {
        var task = taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        if (dto.getPriority() != null) {
            task.setPriority(dto.getPriority());
        }
        if (dto.getAssigneeId() != null) {
            task.setAssignee(userAccountRepository.findById(dto.getAssigneeId()).orElseThrow(() -> new UserNotFoundException("User not found")));
        }

        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getSummary() != null) {
            task.setSummary(dto.getSummary());
        }
        if (dto.getEstimatedTime() != null) {
            task.setEstimatedTime(dto.getEstimatedTime());
        }

        if (dto.getType() != null) {
            task.setType(dto.getType());
        }

        return taskRepository.save(task);
    }
}
