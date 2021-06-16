package com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.commands;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.rest.api.users.exceptions.UserNotFoundException;
import com.secondtonone.jk.jiraclone.domain.project.task.WorkLog;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.dto.CreateWorkLogDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.WorkLogRepository;

public class AddWorkLogCommand {
    private final TaskRepository taskRepository;
    private final UserAccountRepository userAccountRepository;
    private final WorkLogRepository workLogRepository;

    public AddWorkLogCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository, WorkLogRepository workLogRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
        this.workLogRepository = workLogRepository;
    }

    public WorkLog execute(CreateWorkLogDto dto, String key) {
        WorkLog workLog = WorkLog.builder()
                .withComment(dto.getComment())
                .withWorked(dto.getWorked())
                .withCreator(userAccountRepository.findById(dto.getCreatorId()).orElseThrow(() -> new UserNotFoundException("User not found")))
                .withDate(dto.getDate())
                .withFrom(dto.getFrom())
                .withTo(dto.getTo())
                .withTask(taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found")))
                .build();

        return workLogRepository.save(workLog);
    }
}
