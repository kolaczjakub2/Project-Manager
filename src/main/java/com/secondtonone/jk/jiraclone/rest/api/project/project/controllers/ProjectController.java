package com.secondtonone.jk.jiraclone.rest.api.project.project.controllers;

import com.secondtonone.jk.jiraclone.rest.api.project.project.dto.SelectProjectDto;
import com.secondtonone.jk.jiraclone.rest.api.project.project.services.ProjectService;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.SimpleTaskViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Iterable<SelectProjectDto>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}/tasks")
    public ResponseEntity<Iterable<SimpleTaskViewDto>> getAllTasksForProject(@PathVariable UUID projectId) {
        Iterable<SimpleTaskViewDto> tasks = projectService.getAllTasksForProject(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

}
