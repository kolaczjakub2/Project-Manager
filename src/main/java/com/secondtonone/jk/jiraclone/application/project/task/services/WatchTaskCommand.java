package com.secondtonone.jk.jiraclone.application.project.task.services;

import com.secondtonone.jk.jiraclone.application.project.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;

import java.util.UUID;

public class WatchTaskCommand {
    private TaskRepository taskRepository;
    private UserAccountRepository userAccountRepository;

    public WatchTaskCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public Task execute(UUID uuid, String key) {
        Task task = taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.getWatchers().add(userAccountRepository.findById(uuid).orElseThrow(() -> new TaskNotFoundException("User not found")));
        return taskRepository.save(task);
    }
}