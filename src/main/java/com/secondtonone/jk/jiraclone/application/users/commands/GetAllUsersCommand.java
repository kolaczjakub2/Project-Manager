package com.secondtonone.jk.jiraclone.application.users.commands;

import com.secondtonone.jk.jiraclone.domain.users.dto.SelectUserDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.UserAccountRepository;

import java.util.stream.Collectors;

public class GetAllUsersCommand {
    private final UserAccountRepository userAccountRepository;

    public GetAllUsersCommand(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public Iterable<SelectUserDto> execute() {
        return userAccountRepository.findAll().stream().map(userAccount -> SelectUserDto.builder()
                .withId(userAccount.getId())
                .withFirstName(userAccount.getFirstName())
                .withLastName(userAccount.getLastName())
                .withUsername(userAccount.getUsername())
                .build()).collect(Collectors.toSet());
    }
}
