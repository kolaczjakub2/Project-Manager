package com.secondtonone.jk.jiraclone.application.users.services;

import com.secondtonone.jk.jiraclone.application.users.commands.GetAllUsersCommand;
import com.secondtonone.jk.jiraclone.application.users.commands.GetContextCommand;
import com.secondtonone.jk.jiraclone.domain.users.dto.SelectUserDto;

import java.util.UUID;

public class UserService {
    private final GetAllUsersCommand getAllUsersCommand;
    private final GetContextCommand getContextCommand;

    public UserService(GetAllUsersCommand getAllUsersCommand, GetContextCommand getContextCommand) {
        this.getAllUsersCommand = getAllUsersCommand;
        this.getContextCommand = getContextCommand;
    }

    public Iterable<SelectUserDto> getAllUsers() {
        return getAllUsersCommand.execute();
    }

    public UUID getContext() {
        return getContextCommand.execute();
    }
}
