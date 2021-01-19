package com.secondtonone.jk.jiraclone.application.project.commands;

import com.secondtonone.jk.jiraclone.application.project.dto.SelectReleaseDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.ReleaseRepository;

import java.util.UUID;
import java.util.stream.Collectors;

public class GetAllReleasesCommand {

    private final ReleaseRepository releaseRepository;

    public GetAllReleasesCommand(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public Iterable<SelectReleaseDto> execute(UUID projectId) {
        return releaseRepository.findByProjectId(projectId).stream().map(release -> SelectReleaseDto.builder()
                .withId(release.getId())
                .withLabel(release.getLabel())
                .build())
                .collect(Collectors.toSet());
    }
}
