package com.offertestortega.apiUser.service;

import com.offertestortega.apiUser.model.UserEntity;
import com.offertestortega.apiUser.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(UserEntity user) {
        UserEntity registeredUser = userRepository.save(user);
        return registeredUser;
    }

    public Optional<UserEntity> getUser(final Long id) {
        return userRepository.findById(id);
    }
}
