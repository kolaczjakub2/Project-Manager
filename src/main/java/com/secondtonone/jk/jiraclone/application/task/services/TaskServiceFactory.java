package com.secondtonone.jk.jiraclone.application.task.services;

import com.secondtonone.jk.jiraclone.application.task.commands.CreateTaskCommand;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.task.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskServiceFactory {

    @Bean
    public TaskService create(TaskRepository taskRepository) {
        return new TaskService(new CreateTaskCommand(taskRepository));
    }


}
