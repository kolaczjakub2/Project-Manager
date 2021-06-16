package com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.services;

import com.secondtonone.jk.jiraclone.domain.project.task.WorkLog;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.commands.AddWorkLogCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.commands.GetWorkLogCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.dto.CreateWorkLogDto;
import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.dto.WorkLogDto;

import java.util.Optional;

public class WorklogService {

    private final AddWorkLogCommand addWorkLogCommand;
    private final GetWorkLogCommand getWorkLogsCommand;

    public WorklogService(AddWorkLogCommand addWorkLogCommand, GetWorkLogCommand getWorkLogsCommand) {
        this.addWorkLogCommand = addWorkLogCommand;
        this.getWorkLogsCommand = getWorkLogsCommand;
    }


    public Optional<WorkLog> addWorkLog(CreateWorkLogDto dto, String key) {
        var saved = addWorkLogCommand.execute(dto, key);
        return Optional.of(saved);
    }

    public Iterable<WorkLogDto> getWorkLogs(String key) {
        return this.getWorkLogsCommand.execute(key);
    }

}
