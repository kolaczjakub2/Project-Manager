package com.secondtonone.jk.jiraclone.application.project.release.controllers;

import com.secondtonone.jk.jiraclone.application.project.release.dto.SelectReleaseDto;
import com.secondtonone.jk.jiraclone.application.project.release.services.ReleaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("releases")
public class ReleaseController {

    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping
    @RequestMapping("{projectId}")
    public Iterable<SelectReleaseDto> getAllReleases(@PathVariable UUID projectId) {
        return releaseService.getAllReleases(projectId);
    }
}
