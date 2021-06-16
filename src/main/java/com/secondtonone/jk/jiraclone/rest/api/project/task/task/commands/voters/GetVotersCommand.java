package com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.voters;

import com.secondtonone.jk.jiraclone.rest.api.project.task.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.rest.api.users.dto.SelectUserDto;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;

import java.util.stream.Collectors;


public class GetVotersCommand {
    private TaskRepository taskRepository;

    public GetVotersCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<SelectUserDto> execute(String key) {
        return taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found")).getVoters().stream().map(
                userAccount -> SelectUserDto.builder()
                        .withFirstName(userAccount.getFirstName())
                        .withId(userAccount.getId())
                        .withLastName(userAccount.getLastName())
                        .withUsername(userAccount.getUsername())
                        .build())
                .collect(Collectors.toSet());
    }
}
