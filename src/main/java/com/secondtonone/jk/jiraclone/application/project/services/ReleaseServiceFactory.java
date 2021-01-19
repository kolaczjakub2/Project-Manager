package com.secondtonone.jk.jiraclone.application.project.services;

import com.secondtonone.jk.jiraclone.application.project.commands.GetAllReleasesCommand;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.ReleaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReleaseServiceFactory {

    @Bean
    public ReleaseService createReleaseService(ReleaseRepository releaseRepository) {
        return new ReleaseService(new GetAllReleasesCommand(releaseRepository));
    }
}
