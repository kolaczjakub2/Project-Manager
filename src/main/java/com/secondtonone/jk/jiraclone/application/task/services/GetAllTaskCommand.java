package com.secondtonone.jk.jiraclone.application.task.services;

import com.secondtonone.jk.jiraclone.application.task.controllers.TaskDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.TaskRepository;

public class GetAllTaskCommand {
    private final TaskRepository taskRepository;

    public GetAllTaskCommand(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    public Iterable<TaskDto> execute() {
        return taskRepository.findAll();
    }
}
