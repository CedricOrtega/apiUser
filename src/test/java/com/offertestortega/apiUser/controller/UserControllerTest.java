package com.offertestortega.apiUser.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offertestortega.apiUser.model.UserEntity;
import com.offertestortega.apiUser.model.enums.Gender;
import com.offertestortega.apiUser.repository.UserRepository;
import com.offertestortega.apiUser.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    //@Test
    // TODO : Making it work :)
    public void testGetUser() throws Exception {
        mockMvc.perform( get("/user/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserNotFound() throws Exception {
        mockMvc.perform( get("/user/{id}", 2)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testRegisterUserAdultAndFrench() throws Exception {
        mockMvc.perform( post("/user")
                .content("{ \"birthDate\" : \"2000-02-26\", \"countryResidence\" : \"France\", \"gender\" : \"FEMALE\", \"id\" : 0, \"phoneNumber\" : \"string\", \"userName\" : \"string\" }")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
