package com.secondtonone.jk.jiraclone.application.project.release.services;

import com.secondtonone.jk.jiraclone.application.project.project.commands.GetAllReleasesCommand;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ReleaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReleaseServiceFactory {

    @Bean
    public ReleaseService createReleaseService(ReleaseRepository releaseRepository) {
        return new ReleaseService(new GetAllReleasesCommand(releaseRepository));
    }
}
