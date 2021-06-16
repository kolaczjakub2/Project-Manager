package com.secondtonone.jk.jiraclone.rest.api.users.services;

import com.secondtonone.jk.jiraclone.rest.api.users.commands.GetAllUsersCommand;
import com.secondtonone.jk.jiraclone.rest.api.users.commands.GetContextCommand;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceFactory {

    @Bean
    public UserService createUserService(UserAccountRepository userAccountRepository) {
        return new UserService(new GetAllUsersCommand(userAccountRepository), new GetContextCommand(userAccountRepository));
    }

}
