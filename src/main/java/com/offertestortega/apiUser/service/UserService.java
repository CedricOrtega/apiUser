package com.offertestortega.apiUser.service;

import com.offertestortega.apiUser.aop.annotation.Supervision;
import com.offertestortega.apiUser.exceptions.UserDontAllowedException;
import com.offertestortega.apiUser.model.UserEntity;
import com.offertestortega.apiUser.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Supervision(dureeMillis = 5)
    public UserEntity registerUserService(UserEntity user) {
        if(user.getCountryResidence().equals("France") && Period.between(user.getBirthDate(), LocalDate.now()).getYears() > 18){
            UserEntity registeredUser = userRepository.save(user);
            return registeredUser;
        }
        else{
            throw new UserDontAllowedException("User " + user.getUserName() + " don't allowed to register.");
        }
    }

    @Supervision(dureeMillis = 5)
    public Optional<UserEntity> getUserService(final Long id) {
        return userRepository.findById(id);
    }
}
