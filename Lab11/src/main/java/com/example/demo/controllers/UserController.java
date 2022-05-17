package com.example.demo.controllers;


import com.example.demo.entity.UserEntity;
import com.example.demo.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserEntityService userEntityService;

    @Autowired
    public UserController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<UserEntity> getUserList() {
        return userEntityService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UserEntity putUserName(@PathVariable long id, @RequestParam String name) {
        return userEntityService.changeName(id, name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteUser(@PathVariable long id) {
        userEntityService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userEntityService.addUser(user);
    }
}
