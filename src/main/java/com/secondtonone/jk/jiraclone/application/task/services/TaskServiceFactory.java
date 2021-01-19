package com.secondtonone.jk.jiraclone.application.task.services;

import com.secondtonone.jk.jiraclone.application.task.commands.*;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.*;
import org.hibernate.envers.AuditReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskServiceFactory {

    @Bean
    public TaskService createTaskService(TaskRepository taskRepository, UserAccountRepository userAccountRepository,
                                         ReleaseRepository releaseRepository, CommentRepository commentRepository,
                                         WorkLogRepository workLogRepository, AuditReader auditReader,
                                         ProjectRepository projectRepository) {
        return new TaskService(new CreateTaskCommand(taskRepository, userAccountRepository, releaseRepository),
                new GetAllTaskForUserCommand(taskRepository),
                new GetTaskByKeyCommand(taskRepository),
                new UpdateTaskCommand(taskRepository, userAccountRepository),
                new AddCommentCommand(taskRepository, userAccountRepository, commentRepository),
                new GetCommentsCommand(commentRepository),
                new UpdateCommentCommand(commentRepository),
                new AddWorkLogCommand(taskRepository, userAccountRepository, workLogRepository),
                new GetWorkLogCommand(workLogRepository),
                new GetHistoryCommand(auditReader),
                new ChangeStatusCommand(taskRepository),
                new GetSubTaskCommand(taskRepository),
                new GetAllTaskForProjectCommand(taskRepository, projectRepository),
                new AssignMainTaskCommand(taskRepository));
    }
}
