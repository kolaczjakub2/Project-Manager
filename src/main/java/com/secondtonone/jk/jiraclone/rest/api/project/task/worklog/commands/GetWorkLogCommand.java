package com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.commands;

import com.secondtonone.jk.jiraclone.rest.api.project.task.worklog.dto.WorkLogDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.WorkLogRepository;

import java.util.stream.Collectors;

public class GetWorkLogCommand {
    private final WorkLogRepository workLogRepository;

    public GetWorkLogCommand(WorkLogRepository workLogRepository) {
        this.workLogRepository = workLogRepository;
    }

    public Iterable<WorkLogDto> execute(String key) {
        return workLogRepository.findAllByTaskKey(key)
                .stream()
                .map(WorkLogDto::of)
                .collect(Collectors.toSet());
    }
}
