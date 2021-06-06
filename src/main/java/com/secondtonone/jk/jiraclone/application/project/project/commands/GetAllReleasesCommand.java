package com.secondtonone.jk.jiraclone.application.project.project.commands;

import com.secondtonone.jk.jiraclone.application.project.release.dto.SelectReleaseDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ReleaseRepository;

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
