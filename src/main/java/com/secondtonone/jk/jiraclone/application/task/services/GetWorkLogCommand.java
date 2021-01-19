package com.secondtonone.jk.jiraclone.application.task.services;

import com.secondtonone.jk.jiraclone.application.task.controllers.WorkLogDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.WorkLogRepository;

import java.util.stream.Collectors;

public class GetWorkLogCommand {
    private final WorkLogRepository workLogRepository;

    public GetWorkLogCommand(WorkLogRepository workLogRepository) {
        this.workLogRepository = workLogRepository;
    }

    public Iterable<WorkLogDto> execute(String key) {
        return workLogRepository.findAllByTaskKey(key).stream().map(
                workLog -> WorkLogDto.builder()
                        .withId(workLog.getId())
                        .withCreatorId(workLog.getCreator().getId())
                        .withWorked(workLog.getWorked())
                        .withComment(workLog.getComment())
                        .withDate(workLog.getDate())
                        .withFrom(workLog.getFrom())
                        .withTo(workLog.getTo())
                        .withCreatedDate(workLog.getCreatedDate())
                        .build()
        ).collect(Collectors.toSet());
    }
}
