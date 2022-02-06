package com.offertestortega.apiUser.controller;

import com.offertestortega.apiUser.model.UserEntity;
import com.offertestortega.apiUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Create - Register a new user
     * @param user An object user
     * @return The user object registered
     */
    @PostMapping("/user")
    public UserEntity registerUser(@RequestBody UserEntity user) {
        return userService.registerUser(user);
    }

    /**
     * Read - Get one user
     * @param id The id of the user
     * @return An User object full filled
     */
    @GetMapping("/user/{id}")
    public UserEntity getUser(@PathVariable("id") final Long id) {
        Optional<UserEntity> user = userService.getUser(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
}
