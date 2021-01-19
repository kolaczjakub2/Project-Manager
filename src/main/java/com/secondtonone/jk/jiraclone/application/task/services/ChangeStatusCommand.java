package com.secondtonone.jk.jiraclone.application.task.services;

import com.secondtonone.jk.jiraclone.application.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.domain.task.Task;
import com.secondtonone.jk.jiraclone.domain.task.enums.Status;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.TaskRepository;

public class ChangeStatusCommand {
    private final TaskRepository taskRepository;

    public ChangeStatusCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(String status, String key) {
        Task task = taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setStatus(Status.valueOf(status));
        return taskRepository.save(task);
    }
}
