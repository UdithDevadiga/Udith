package com.robosoft.manytomany.service;

import com.robosoft.manytomany.modal.User;
import com.robosoft.manytomany.repository.ComputerRepository;
import com.robosoft.manytomany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ComputerRepository computerRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
