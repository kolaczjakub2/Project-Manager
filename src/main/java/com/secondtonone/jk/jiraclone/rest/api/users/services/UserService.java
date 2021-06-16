package com.secondtonone.jk.jiraclone.rest.api.users.services;

import com.secondtonone.jk.jiraclone.rest.api.users.commands.GetAllUsersCommand;
import com.secondtonone.jk.jiraclone.rest.api.users.commands.GetContextCommand;
import com.secondtonone.jk.jiraclone.rest.api.users.dto.SelectUserDto;

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
