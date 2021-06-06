package com.secondtonone.jk.jiraclone.application.users.commands;

import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;

import java.util.UUID;

public class GetContextCommand {
    private final UserAccountRepository userAccountRepository;

    public GetContextCommand(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public UUID execute() {
        return userAccountRepository.findByFirstName("Jakub").get().getId();
    }
}
