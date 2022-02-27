package com.offertestortega.apiUser.controller;

import com.offertestortega.apiUser.model.UserEntity;
import com.offertestortega.apiUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.registerUserService(user), HttpStatus.CREATED);
    }

    /**
     * Read - Get one user
     * @param id The id of the user
     * @return An User object full filled
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") final Long id) {
        Optional<UserEntity> user = userService.getUserService(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    }
}
