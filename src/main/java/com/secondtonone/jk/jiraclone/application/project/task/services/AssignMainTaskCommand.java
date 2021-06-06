package com.secondtonone.jk.jiraclone.application.project.task.services;

import com.secondtonone.jk.jiraclone.application.project.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

import java.util.UUID;

public class AssignMainTaskCommand {
    private final TaskRepository taskRepository;

    public AssignMainTaskCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(UUID uuid, String key) {
        Task task = taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setMainTask(taskRepository.findById(uuid).orElseThrow(() -> new TaskNotFoundException("Task not found")));
        return taskRepository.save(task);
    }
}
