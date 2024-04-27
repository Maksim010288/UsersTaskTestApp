package com.example.UsersProject.service;

import com.example.UsersProject.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsersServiceTest {

    @Autowired
    UsersService usersService;


    @Test
    void add() {
//        UserEntity user = new UserEntity("test@gmail.com", "Адаменко", "Вадим", "1999-05-23");
//        usersService.add(user);
        Assertions.assertEquals(5, usersService.getAll().size());

    }

    @Test
    void getAll() {
      Assertions.assertEquals(5, usersService.getAll().size());
    }

    @Test
    void findByFromLess() {
        Assertions.assertEquals(5, usersService.findByFromLess(36).size());
    }

    @Test
    void findByFrom() {
        Assertions.assertEquals(4, usersService.findByFromLess(32).size());
    }

    @Test
    void updateUserEmail() {
        UserEntity user = new UserEntity();
        user.setEmail("taradayka@gmail.com");
        Assertions.assertEquals(user.getEmail(), usersService.updateUserEmail(user, 11).getEmail());
    }

    @Test
    void updateUserEmails() {
        UserEntity user = new UserEntity();
        user.setEmail("taradayka@gmail.com");
        user.setLastName("Anton");
        user.setFirstName("Bogdanov");
        Assertions.assertEquals(user.getEmail(), usersService.updateUserEmailLastFirstName(user, 11).getEmail());
    }

    @Test
    void updateUserLastName() {
        UserEntity user = new UserEntity();
        user.setEmail("taradayka@gmail.com");
        user.setLastName("Anton");
        user.setFirstName("Bogdanov");
        Assertions.assertEquals(user.getLastName(), usersService.updateUserEmailLastFirstName(user, 11).getLastName());
    }

    @Test
    void updateUserFirstName() {
        UserEntity user = new UserEntity();
        user.setEmail("taradayka@gmail.com");
        user.setLastName("Anton");
        user.setFirstName("Bogdanov");
        Assertions.assertEquals(user.getFirstName(), usersService.updateUserEmailLastFirstName(user, 11).getFirstName());
    }

    @Test
    void updateAll() {
        UserEntity user = new UserEntity();
        user.setEmail("taradayka@gmail.com");
        user.setLastName("Anton");
        user.setFirstName("Bogdanov");
        user.setDataOfBirth("2002-10-12");

        Assertions.assertEquals(user.toString(), usersService.updateAll(user, 12).toString());
    }

    @Test
    void deleteUser() {
    }
}