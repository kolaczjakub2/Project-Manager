package com.secondtonone.jk.jiraclone.rest.api.project.task.comment.services;

import com.secondtonone.jk.jiraclone.domain.project.repositories.*;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.commands.AddCommentCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.commands.GetCommentsCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.comment.commands.UpdateCommentCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommentServiceFactory {

    @Bean
    public CommentService createCommentService(TaskRepository taskRepository, UserAccountRepository userAccountRepository,
                                               CommentRepository commentRepository) {
        return new CommentService(
                new AddCommentCommand(taskRepository, userAccountRepository, commentRepository),
                new GetCommentsCommand(commentRepository),
                new UpdateCommentCommand(commentRepository));
    }

}
