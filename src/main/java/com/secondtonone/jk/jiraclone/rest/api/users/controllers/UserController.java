package com.secondtonone.jk.jiraclone.rest.api.users.controllers;

import com.secondtonone.jk.jiraclone.rest.api.users.services.UserService;
import com.secondtonone.jk.jiraclone.rest.api.users.dto.SelectUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Iterable<SelectUserDto>> getAllProjects() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/context")
    public ResponseEntity<UUID> getContext() {
        return new ResponseEntity<>(userService.getContext(), HttpStatus.OK);
    }
}
