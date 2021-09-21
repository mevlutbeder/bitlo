package com.bitlo.controller;

import com.bitlo.model.User;
import com.bitlo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController extends ApiController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public List<User> getAll() {
        return getUser();
    }

    public List<User> getUser() {
        return userService.findAll();
    }

}