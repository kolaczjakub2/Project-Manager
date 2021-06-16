package com.secondtonone.jk.jiraclone.rest.api.project.release.commands;

import com.secondtonone.jk.jiraclone.rest.api.project.release.dto.SelectReleaseDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ReleaseRepository;

import java.util.UUID;
import java.util.stream.Collectors;

public class GetAllReleasesCommand {

    private final ReleaseRepository releaseRepository;

    public GetAllReleasesCommand(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public Iterable<SelectReleaseDto> execute(UUID projectId) {
        return releaseRepository.findByProjectId(projectId)
                .stream()
                .map(SelectReleaseDto::of)
                .collect(Collectors.toSet());
    }
}
