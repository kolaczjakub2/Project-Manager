package com.secondtonone.jk.jiraclone.application.project.task.services;

import com.secondtonone.jk.jiraclone.application.project.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.application.users.dto.SelectUserDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

import java.util.stream.Collectors;

public class GetWatchersCommand {
    private TaskRepository taskRepository;

    public GetWatchersCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<SelectUserDto> execute(String key) {
        return taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found")).getWatchers().stream().map(
                userAccount -> SelectUserDto.builder()
                        .withFirstName(userAccount.getFirstName())
                        .withId(userAccount.getId())
                        .withLastName(userAccount.getLastName())
                        .withUsername(userAccount.getUsername())
                        .build())
                .collect(Collectors.toSet());
    }
}
