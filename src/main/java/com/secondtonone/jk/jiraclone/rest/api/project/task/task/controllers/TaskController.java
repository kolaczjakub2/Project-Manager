package com.secondtonone.jk.jiraclone.rest.api.project.task.task.controllers;

import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.*;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.services.TaskService;
import com.secondtonone.jk.jiraclone.rest.api.users.dto.SelectUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody CreateTaskRequestDto dto) {
        Optional<Task> saved = taskService.saveTask(dto);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PatchMapping("/key/{key}")
    public ResponseEntity<Void> updateTask(@RequestBody UpdateTaskRequestDto dto, @PathVariable String key) {
        Optional<Task> saved = taskService.updateTask(dto, key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Iterable<SimpleTaskViewDto>> getAllTask(@PathVariable UUID userId) {
        Iterable<SimpleTaskViewDto> tasks = taskService.getAllTaskForUser(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/key/{key}")
    public ResponseEntity<TaskDetailsDto> getTaskByKey(@PathVariable String key) {
        TaskDetailsDto task = taskService.getTaskByKey(key);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/key/{key}/subtask")
    public ResponseEntity<Iterable<SubTaskViewDto>> getSubtasks(@PathVariable String key) {
        Iterable<SubTaskViewDto> tasks = taskService.getSubtasks(key);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PatchMapping("/key/{key}/status")
    public ResponseEntity<Void> changeStatus(@PathVariable String key, @RequestBody String status) {
        Optional<Task> saved = taskService.changeStatus(status, key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PatchMapping("/key/{key}/mainTask")
    public ResponseEntity<Void> assignMainTask(@PathVariable String key, @RequestBody String uuid) {
        Optional<Task> saved = taskService.assignMainTask(UUID.fromString(uuid), key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PostMapping("/key/{key}/vote")
    public ResponseEntity<Void> addVote(@PathVariable String key, @RequestBody String uuid) {
        Optional<Task> saved = taskService.addVote(UUID.fromString(uuid), key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/key/{key}/voters")
    public ResponseEntity<Iterable<SelectUserDto>> getVoters(@PathVariable String key) {
        Iterable<SelectUserDto> voters = taskService.getVoters(key);
        return new ResponseEntity<>(voters, HttpStatus.OK);
    }

    @GetMapping("/key/{key}/watchers")
    public ResponseEntity<Iterable<SelectUserDto>> getWatchers(@PathVariable String key) {
        Iterable<SelectUserDto> voters = taskService.getWatchers(key);
        return new ResponseEntity<>(voters, HttpStatus.OK);
    }

    @PostMapping("/key/{key}/watcher")
    public ResponseEntity<Void> watchTask(@PathVariable String key, @RequestBody String uuid) {
        Optional<Task> saved = taskService.watchTask(UUID.fromString(uuid), key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}

