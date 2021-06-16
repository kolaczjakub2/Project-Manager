package com.secondtonone.jk.jiraclone.rest.api.project.task.task.services;

import com.secondtonone.jk.jiraclone.domain.project.repositories.*;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;
import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetAllTaskForProjectCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.*;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.subTasks.AssignMainTaskCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.subTasks.GetSubTaskCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.voters.AddVoteTaskCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.voters.GetVotersCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.watchers.GetWatchersCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.watchers.WatchTaskCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TaskServiceFactory {

    @Bean
    public TaskService createTaskService(TaskRepository taskRepository, UserAccountRepository userAccountRepository,
                                         ReleaseRepository releaseRepository,WorkLogRepository workLogRepository,
                                         ProjectRepository projectRepository) {
        return new TaskService(new CreateTaskCommand(taskRepository, userAccountRepository, releaseRepository),
                new GetAllTaskForUserCommand(taskRepository),
                new GetTaskByKeyCommand(taskRepository),
                new UpdateTaskCommand(taskRepository, userAccountRepository),
                new ChangeStatusCommand(taskRepository),
                new GetSubTaskCommand(taskRepository),
                new GetAllTaskForProjectCommand(taskRepository, projectRepository),
                new AssignMainTaskCommand(taskRepository),
                new AddVoteTaskCommand(taskRepository, userAccountRepository),
                new GetVotersCommand(taskRepository),
                new GetWatchersCommand(taskRepository),
                new WatchTaskCommand(taskRepository, userAccountRepository));
    }
}
