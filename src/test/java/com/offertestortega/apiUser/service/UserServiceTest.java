package com.offertestortega.apiUser.service;

import com.offertestortega.apiUser.exceptions.UserDontAllowedException;
import com.offertestortega.apiUser.model.UserEntity;
import com.offertestortega.apiUser.model.enums.Gender;
import com.offertestortega.apiUser.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    ApplicationContext context;

    @MockBean
    UserRepository mockRepository;

    @Before
    public void init() {


    }

    @Test
    public void testRegisterUserService_when_AdultAndFrenchUser() {
        // Arrange

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("CeceSpana");
        userEntity.setBirthDate(LocalDate.EPOCH);
        userEntity.setGender(Gender.MALE);
        userEntity.setCountryResidence("France");
        userEntity.setPhoneNumber("0607080910");
        userEntity.setId(1L);

        when(mockRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        // Act
        UserEntity actual = userService.registerUserService(userEntity);

        // Assert
        assertEquals(LocalDate.EPOCH, actual.getBirthDate());
        assertEquals("France", actual.getCountryResidence());
        assertEquals("CeceSpana", actual.getUserName());
        assertEquals(Gender.MALE, actual.getGender());
        assertEquals("0607080910", actual.getPhoneNumber());
        assertEquals(Long.valueOf(1), actual.getId());
    }

    @Test
    public void testRegisterUserService_when_AdultAndNotFrenchUser() {
        // Arrange

        UserEntity mockUserNotFrench = new UserEntity();
        mockUserNotFrench.setUserName("Ivana");
        mockUserNotFrench.setBirthDate(LocalDate.EPOCH);
        mockUserNotFrench.setGender(Gender.FEMALE);
        mockUserNotFrench.setCountryResidence("Ukraine");
        mockUserNotFrench.setPhoneNumber("0607080912");
        mockUserNotFrench.setId(2L);

        // Act & Assert
        Assertions.assertThrows(UserDontAllowedException.class, () -> {
            userService.registerUserService(mockUserNotFrench);
        });
    }

    @Test
    public void testGetUserService_when_UserExists() {
        // Arrange

        UserEntity mockUserExisting = new UserEntity();
        mockUserExisting.setUserName("CeceSpana");
        mockUserExisting.setBirthDate(LocalDate.EPOCH);
        mockUserExisting.setGender(Gender.MALE);
        mockUserExisting.setCountryResidence("France");
        mockUserExisting.setPhoneNumber("0607080910");
        mockUserExisting.setId(1L);

        when(mockRepository.findById(any())).thenReturn(Optional.of(mockUserExisting));

        // Act
        Optional<UserEntity> actual = userService.getUserService(1L);

        // Assert
        assertEquals(LocalDate.EPOCH, actual.get().getBirthDate());
        assertEquals("France", actual.get().getCountryResidence());
        assertEquals("CeceSpana", actual.get().getUserName());
        assertEquals(Gender.MALE, actual.get().getGender());
        assertEquals("0607080910", actual.get().getPhoneNumber());
        assertEquals(Long.valueOf(1), actual.get().getId());
    }
}
