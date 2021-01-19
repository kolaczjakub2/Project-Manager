package com.secondtonone.jk.jiraclone.application.task.commands;

import com.secondtonone.jk.jiraclone.application.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.application.users.exceptions.UserNotFoundException;
import com.secondtonone.jk.jiraclone.domain.task.Comment;
import com.secondtonone.jk.jiraclone.domain.task.dto.CreateCommentRequestDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.CommentRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.UserAccountRepository;

public class AddCommentCommand {
    private final TaskRepository taskRepository;
    private final UserAccountRepository userAccountRepository;
    private final CommentRepository commentRepository;

    public AddCommentCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository, CommentRepository commentRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
        this.commentRepository = commentRepository;
    }

    public Comment execute(CreateCommentRequestDto dto, String key) throws TaskNotFoundException {
        Comment comment = Comment.builder()
                .withContent(dto.getContent())
                .withTask(taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found")))
                .withAuthor(userAccountRepository.findById(dto.getCreatorId()).orElseThrow(() -> new UserNotFoundException("User not found")))
                .build();

        return commentRepository.save(comment);
    }
}
