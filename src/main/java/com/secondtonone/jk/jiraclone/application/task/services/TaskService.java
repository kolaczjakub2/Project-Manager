package com.secondtonone.jk.jiraclone.application.task.services;

import com.secondtonone.jk.jiraclone.application.task.commands.CreateTaskCommand;
import com.secondtonone.jk.jiraclone.domain.task.dto.CreateTaskRequestDto;

import java.util.Optional;

public class TaskService {

    private final CreateTaskCommand createTaskCommand;

    public TaskService(CreateTaskCommand createTaskCommand) {
        this.createTaskCommand = createTaskCommand;
    }

    public Optional<Boolean> saveTask(CreateTaskRequestDto dto) {
        try {
            Boolean saved = createTaskCommand.execute(dto);
            return Optional.of(saved);
        } catch (TaskCreationException e) {
            return Optional.empty();
        }
    }
}
