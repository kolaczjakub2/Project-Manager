package com.secondtonone.jk.jiraclone.rest.api.project.task.comment.commands;

import com.secondtonone.jk.jiraclone.domain.project.repositories.CommentRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.project.task.Comment;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.dto.CreateCommentRequestDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.rest.api.users.exceptions.UserNotFoundException;

public class AddCommentCommand {
    private final TaskRepository taskRepository;
    private final UserAccountRepository userAccountRepository;
    private final CommentRepository commentRepository;

    public AddCommentCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository, CommentRepository commentRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
        this.commentRepository = commentRepository;
    }

    public Comment execute(CreateCommentRequestDto dto, String key) throws TaskNotFoundException, UserNotFoundException {
        Comment comment = Comment.builder()
                .withContent(dto.getContent())
                .withTask(taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found")))
                .withAuthor(userAccountRepository.findById(dto.getCreatorId()).orElseThrow(() -> new UserNotFoundException("User not found")))
                .build();

        return commentRepository.save(comment);
    }
}
