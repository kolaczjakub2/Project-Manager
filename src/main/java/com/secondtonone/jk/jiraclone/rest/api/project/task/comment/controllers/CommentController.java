package com.secondtonone.jk.jiraclone.rest.api.project.task.comment.controllers;

import com.secondtonone.jk.jiraclone.domain.project.task.Comment;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.dto.CommentDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.dto.CreateCommentRequestDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.services.CommentService;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.UpdateCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("tasks")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/key/{key}/comments")
    public ResponseEntity<Void> addComment(@RequestBody CreateCommentRequestDto dto, @PathVariable String key) {
        Optional<Comment> saved = commentService.addComment(dto, key);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/key/{key}/comments")
    public ResponseEntity<Iterable<CommentDto>> getComments(@PathVariable String key) {
        Iterable<CommentDto> comments = commentService.getComments(key);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PatchMapping("/key/{key}/comments/{commentId}")
    public ResponseEntity<Void> updateComment(@RequestBody UpdateCommentDto dto, @PathVariable UUID commentId) {
        Optional<Comment> saved = commentService.updateComment(dto, commentId);
        if (saved.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
