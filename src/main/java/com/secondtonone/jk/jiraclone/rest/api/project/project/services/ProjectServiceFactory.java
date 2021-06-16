package com.secondtonone.jk.jiraclone.rest.api.project.project.services;

import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetAllProjectCommand;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ProjectRepository;
import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetAllTaskForProjectCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProjectServiceFactory {

    @Bean
    public ProjectService createProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        return new ProjectService(
                new GetAllProjectCommand(projectRepository),
                new GetAllTaskForProjectCommand(taskRepository, projectRepository));
    }

}
