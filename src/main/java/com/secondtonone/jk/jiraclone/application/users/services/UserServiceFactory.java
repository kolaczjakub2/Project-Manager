package com.secondtonone.jk.jiraclone.application.users.services;

import com.secondtonone.jk.jiraclone.application.users.commands.GetAllUsersCommand;
import com.secondtonone.jk.jiraclone.application.users.commands.GetContextCommand;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.UserAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceFactory {

    @Bean
    public UserService createUserService(UserAccountRepository userAccountRepository) {
        return new UserService(new GetAllUsersCommand(userAccountRepository), new GetContextCommand(userAccountRepository));
    }

}
