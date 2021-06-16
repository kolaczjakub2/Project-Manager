package com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Status;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

public class ChangeStatusCommand {
    private final TaskRepository taskRepository;

    public ChangeStatusCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(String status, String key) {
        var task = taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setStatus(Status.valueOf(status));
        return taskRepository.save(task);
    }
}
