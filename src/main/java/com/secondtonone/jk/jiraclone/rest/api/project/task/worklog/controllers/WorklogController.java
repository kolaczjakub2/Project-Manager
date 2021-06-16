package com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.controllers;

import com.secondtonone.jk.jiraclone.domain.project.task.WorkLog;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.dto.CreateWorkLogDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.dto.WorkLogDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.services.WorklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class WorklogController {

    private final WorklogService worklogService;

    @Autowired
    public WorklogController(WorklogService worklogService) {
        this.worklogService = worklogService;
    }

    @PostMapping("/key/{key}/workLog")
    public ResponseEntity<Void> addWorkLog(@PathVariable String key, @RequestBody CreateWorkLogDto dto) {
        Optional<WorkLog> saved = worklogService.addWorkLog(dto, key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/key/{key}/workLog")
    public ResponseEntity<Iterable<WorkLogDto>> getWorkLogs(@PathVariable String key) {
        Iterable<WorkLogDto> workLogs = worklogService.getWorkLogs(key);
        return new ResponseEntity<>(workLogs, HttpStatus.OK);
    }
}
