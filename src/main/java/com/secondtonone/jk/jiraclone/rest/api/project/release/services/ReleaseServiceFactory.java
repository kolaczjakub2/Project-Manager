package com.secondtonone.jk.jiraclone.rest.api.project.release.services;

import com.secondtonone.jk.jiraclone.rest.api.project.release.commands.GetAllReleasesCommand;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ReleaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReleaseServiceFactory {

    @Bean
    public ReleaseService createReleaseService(ReleaseRepository releaseRepository) {
        return new ReleaseService(new GetAllReleasesCommand(releaseRepository));
    }
}
