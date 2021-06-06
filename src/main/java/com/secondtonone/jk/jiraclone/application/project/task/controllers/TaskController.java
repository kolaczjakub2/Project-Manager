package com.secondtonone.jk.jiraclone.application.project.task.controllers;

import com.secondtonone.jk.jiraclone.application.project.task.services.TaskService;
import com.secondtonone.jk.jiraclone.domain.project.task.Comment;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.task.WorkLog;
import com.secondtonone.jk.jiraclone.application.project.task.dto.*;
import com.secondtonone.jk.jiraclone.application.users.dto.SelectUserDto;
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
    ResponseEntity<Void> createTask(@RequestBody CreateTaskRequestDto dto) {
        Optional<Task> saved = taskService.saveTask(dto);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/project/{projectId}")
    ResponseEntity<Iterable<SimpleTaskViewDto>> getAllTasksForProject(@PathVariable UUID projectId) {
        Iterable<SimpleTaskViewDto> tasks = taskService.getAllTasksForProject(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }


    @PatchMapping("/key/{key}")
    ResponseEntity<Void> updateTask(@RequestBody UpdateTaskRequestDto dto, @PathVariable String key) {
        Optional<Task> saved = taskService.updateTask(dto, key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{userId}")
    ResponseEntity<Iterable<SimpleTaskViewDto>> getAllTask(@PathVariable UUID userId) {
        Iterable<SimpleTaskViewDto> tasks = taskService.getAllTaskForUser(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/key/{key}")
    ResponseEntity<TaskDetailsDto> getTaskByKey(@PathVariable String key) {
        TaskDetailsDto task = taskService.getTaskByKey(key);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/key/{key}/subtask")
    ResponseEntity<Iterable<SubTaskViewDto>> getSubtasks(@PathVariable String key) {
        Iterable<SubTaskViewDto> tasks = taskService.getSubtasks(key);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/key/{key}/comments")
    ResponseEntity<Void> addComment(@RequestBody CreateCommentRequestDto dto, @PathVariable String key) {
        Optional<Comment> saved = taskService.addComment(dto, key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/key/{key}/comments")
    ResponseEntity<Iterable<CommentDto>> getComments(@PathVariable String key) {
        Iterable<CommentDto> comments = taskService.getComments(key);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PatchMapping("/key/{key}/comments/{commentId}")
    ResponseEntity<Void> updateComment(@RequestBody UpdateCommentDto dto, @PathVariable UUID commentId) {
        Optional<Comment> saved = taskService.updateComment(dto, commentId);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PostMapping("/key/{key}/workLog")
    ResponseEntity<Void> addWorkLog(@PathVariable String key, @RequestBody CreateWorkLogDto dto) {
        Optional<WorkLog> saved = taskService.addWorkLog(dto, key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/key/{key}/workLog")
    ResponseEntity<Iterable<WorkLogDto>> getWorkLogs(@PathVariable String key) {
        Iterable<WorkLogDto> workLogs = taskService.getWorkLogs(key);
        return new ResponseEntity<>(workLogs, HttpStatus.OK);
    }

    @PatchMapping("/key/{key}/status")
    ResponseEntity<Void> changeStatus(@PathVariable String key, @RequestBody String status) {
        Optional<Task> saved = taskService.changeStatus(status, key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

//    @GetMapping("/key/{key}/history")
//    ResponseEntity getHistory(@PathVariable String key) {
//        return new ResponseEntity(taskService.getHistory(key), HttpStatus.OK);
//    }

    @PatchMapping("/key/{key}/mainTask")
    ResponseEntity<Void> assignMainTask(@PathVariable String key, @RequestBody String uuid) {
        Optional<Task> saved = taskService.assignMainTask(UUID.fromString(uuid), key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PostMapping("/key/{key}/vote")
    ResponseEntity<Void> addVote(@PathVariable String key, @RequestBody String uuid) {
        Optional<Task> saved = taskService.addVote(UUID.fromString(uuid), key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/key/{key}/voters")
    ResponseEntity<Iterable<SelectUserDto>> getVoters(@PathVariable String key) {
        Iterable<SelectUserDto> voters = taskService.getVoters(key);
        return new ResponseEntity<>(voters, HttpStatus.OK);
    }

    @GetMapping("/key/{key}/watchers")
    ResponseEntity<Iterable<SelectUserDto>> getWatchers(@PathVariable String key) {
        Iterable<SelectUserDto> voters = taskService.getWatchers(key);
        return new ResponseEntity<>(voters, HttpStatus.OK);
    }

    @PostMapping("/key/{key}/watcher")
    ResponseEntity<Void> watchTask(@PathVariable String key, @RequestBody String uuid) {
        Optional<Task> saved = taskService.watchTask(UUID.fromString(uuid), key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}

