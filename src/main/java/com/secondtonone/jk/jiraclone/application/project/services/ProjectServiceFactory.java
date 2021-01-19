package com.secondtonone.jk.jiraclone.application.project.services;

import com.secondtonone.jk.jiraclone.application.project.commands.GetAllProjectCommand;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.ProjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectServiceFactory {

    @Bean
    public ProjectService createProjectService(ProjectRepository projectRepository) {
        return new ProjectService(new GetAllProjectCommand(projectRepository));
    }

}
