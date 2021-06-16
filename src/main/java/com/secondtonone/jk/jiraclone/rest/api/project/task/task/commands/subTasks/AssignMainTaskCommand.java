package com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.subTasks;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

import java.util.UUID;

public class AssignMainTaskCommand {
    private final TaskRepository taskRepository;

    public AssignMainTaskCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(UUID uuid, String key) {
        var task = taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setMainTask(taskRepository.findById(uuid).orElseThrow(() -> new TaskNotFoundException("Task not found")));
        return taskRepository.save(task);
    }
}
