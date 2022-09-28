package com.robosoft.manytomany.controller;

import com.robosoft.manytomany.modal.User;
import com.robosoft.manytomany.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    Userservice userservice;
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return userservice.saveUser(user);
    }
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userservice.getUsers();
    }
}
