package com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.voters;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;

import java.util.UUID;

public class AddVoteTaskCommand {
    private final TaskRepository taskRepository;
    private final UserAccountRepository userAccountRepository;

    public AddVoteTaskCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public Task execute(UUID uuid, String key) {
        Task task = taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.getVoters().add(userAccountRepository.findById(uuid).orElseThrow(() -> new TaskNotFoundException("User not found")));
        return taskRepository.save(task);

    }
}
