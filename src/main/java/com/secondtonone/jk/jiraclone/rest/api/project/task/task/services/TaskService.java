package com.secondtonone.jk.jiraclone.rest.api.project.task.task.services;

import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.rest.api.project.project.commands.GetAllTaskForProjectCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.*;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.subTasks.AssignMainTaskCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.subTasks.GetSubTaskCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.voters.AddVoteTaskCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.voters.GetVotersCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.watchers.GetWatchersCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.commands.watchers.WatchTaskCommand;
import com.secondtonone.jk.jiraclone.rest.api.project.task.task.dto.*;
import com.secondtonone.jk.jiraclone.rest.api.users.dto.SelectUserDto;

import java.util.Optional;
import java.util.UUID;

public class TaskService {

    private final CreateTaskCommand createTaskCommand;
    private final GetAllTaskForUserCommand getAllTaskForUserCommand;
    private final GetTaskByKeyCommand getTaskByKeyCommand;
    private final UpdateTaskCommand updateTaskCommand;
    private final ChangeStatusCommand changeStatusCommand;
    private final GetSubTaskCommand getSubtasksCommand;
    private final GetAllTaskForProjectCommand getAllTasksForProjectCommand;
    private final AssignMainTaskCommand assignMainTaskCommand;
    private final AddVoteTaskCommand addVoteTaskCommand;
    private final GetVotersCommand getVotersCommand;
    private final GetWatchersCommand getWatchersCommand;
    private final WatchTaskCommand watchTaskCommand;

    public TaskService(CreateTaskCommand createTaskCommand, GetAllTaskForUserCommand getAllTaskForUserCommand,
                       GetTaskByKeyCommand getTaskByKeyCommand, UpdateTaskCommand updateTaskCommand,
                       ChangeStatusCommand changeStatusCommand, GetSubTaskCommand getSubtasksCommand,
                       GetAllTaskForProjectCommand getAllTasksForProjectCommand, AssignMainTaskCommand assignMainTaskCommand,
                       AddVoteTaskCommand addVoteTaskCommand, GetVotersCommand getVotersCommand, GetWatchersCommand getWatchersCommand,
                       WatchTaskCommand watchTaskCommand) {
        this.createTaskCommand = createTaskCommand;
        this.getAllTaskForUserCommand = getAllTaskForUserCommand;
        this.getTaskByKeyCommand = getTaskByKeyCommand;
        this.updateTaskCommand = updateTaskCommand;
        this.changeStatusCommand = changeStatusCommand;
        this.getSubtasksCommand = getSubtasksCommand;
        this.getAllTasksForProjectCommand = getAllTasksForProjectCommand;
        this.assignMainTaskCommand = assignMainTaskCommand;
        this.addVoteTaskCommand = addVoteTaskCommand;
        this.getVotersCommand = getVotersCommand;
        this.getWatchersCommand = getWatchersCommand;
        this.watchTaskCommand = watchTaskCommand;
    }

    public Optional<Task> saveTask(CreateTaskRequestDto dto) {
        Task saved = createTaskCommand.execute(dto);
        return Optional.of(saved);
    }

    public Iterable<SimpleTaskViewDto> getAllTaskForUser(UUID userId) {
        return this.getAllTaskForUserCommand.execute(userId);
    }

    public TaskDetailsDto getTaskByKey(String key) {
        return this.getTaskByKeyCommand.execute(key);
    }

    public Optional<Task> updateTask(UpdateTaskRequestDto dto, String key) {
        Task saved = updateTaskCommand.execute(dto, key);
        return Optional.of(saved);
    }

    public Optional<Task> changeStatus(String status, String key) {
        Task saved = this.changeStatusCommand.execute(status, key);
        return Optional.of(saved);
    }

    public Iterable<SubTaskViewDto> getSubtasks(String key) {
        return this.getSubtasksCommand.execute(key);
    }

    public Optional<Task> assignMainTask(UUID uuid, String key) {
        Task saved = this.assignMainTaskCommand.execute(uuid, key);
        return Optional.of(saved);
    }

    public Optional<Task> addVote(UUID uuid, String key) {
        Task saved = this.addVoteTaskCommand.execute(uuid, key);
        return Optional.of(saved);
    }

    public Iterable<SelectUserDto> getVoters(String key) {
        return this.getVotersCommand.execute(key);
    }

    public Iterable<SelectUserDto> getWatchers(String key) {
        return this.getWatchersCommand.execute(key);
    }

    public Optional<Task> watchTask(UUID uuid, String key) {
        Task saved = this.watchTaskCommand.execute(uuid, key);
        return Optional.of(saved);
    }
}
