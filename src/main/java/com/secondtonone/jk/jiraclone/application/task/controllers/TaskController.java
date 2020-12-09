package com.secondtonone.jk.jiraclone.application.task.controllers;

import com.secondtonone.jk.jiraclone.application.task.services.TaskService;
import com.secondtonone.jk.jiraclone.domain.task.dto.CreateTaskRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    ResponseEntity<Object> createTask(@RequestBody CreateTaskRequestDto dto) {
        Optional<Boolean> saved = taskService.saveTask(dto);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    ResponseEntity<Object> getAllTask() {
        Iterable<TaskDto> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
