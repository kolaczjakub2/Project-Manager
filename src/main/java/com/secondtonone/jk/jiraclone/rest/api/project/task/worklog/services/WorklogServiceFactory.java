package com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.services;

import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.WorkLogRepository;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.commands.AddWorkLogCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.commands.GetWorkLogCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WorklogServiceFactory {

    @Bean
    public WorklogService createWorkLogService(TaskRepository taskRepository, UserAccountRepository userAccountRepository, WorkLogRepository workLogRepository) {
        return new WorklogService(
                new AddWorkLogCommand(taskRepository, userAccountRepository, workLogRepository),
                new GetWorkLogCommand(workLogRepository));
    }
}
