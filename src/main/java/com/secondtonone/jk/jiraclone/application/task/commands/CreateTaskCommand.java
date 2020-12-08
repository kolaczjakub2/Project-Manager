package com.secondtonone.jk.jiraclone.application.task.commands;

import com.secondtonone.jk.jiraclone.application.task.services.TaskCreationException;
import com.secondtonone.jk.jiraclone.domain.task.dto.CreateTaskRequestDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.task.TaskRepository;

public class CreateTaskCommand {
    private final TaskRepository taskRepository;

    public CreateTaskCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Boolean execute(CreateTaskRequestDto dto) {
        try {
            taskRepository.save(dto.toTask());
            return true;
        } catch (Exception e) {
            throw new TaskCreationException(e);
        }
    }
}
