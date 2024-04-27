package com.example.UsersProject.controller;

import com.example.UsersProject.entity.UserEntity;
import com.example.UsersProject.service.UsersService;
import com.example.UsersProject.validate.ValidateUserDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.JavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok().body(usersService.getAll());
    }

    @GetMapping("/all/{old}")
    public ResponseEntity<List<UserEntity>> getLessOfAl(@PathVariable Integer old) {
        return ResponseEntity.ok().body(usersService.findByFromLess(old));
    }

    @PostMapping("/add")
    @JsonFormat(pattern = JsonFormat.DEFAULT_LOCALE)
    public ResponseEntity<String> save(@RequestBody UserEntity userEntity) {
        if (ValidateUserDate.validationMail(userEntity.getEmail())) {
            String message = usersService.add(userEntity);
            return ResponseEntity.ok().body(message);
        }else {
            return ResponseEntity.badRequest().body("not added(the email is not correct)");
        }
    }

    @PostMapping("/update/email/{id}")
    public ResponseEntity<String> updateUserEmail(@PathVariable Integer id,
                                                  @RequestBody UserEntity userEntity) {
        UserEntity user = usersService.updateUserEmail(userEntity, id);
        return ResponseEntity.ok().body(user.getEmail() + " has be changes");
    }

    @PostMapping("/update/email_last_first_name/{id}")
    public ResponseEntity<String> updateEmailLastFirstName(
            @PathVariable Integer id,
            @RequestBody UserEntity userEntity) {
        UserEntity user = usersService.updateUserEmailLastFirstName(userEntity, id);
        return ResponseEntity.ok().body(user.getEmail() + " has be changes");
    }

    @PostMapping("/update/all/{id}")
    public ResponseEntity<String> updateAll(
            @PathVariable Integer id,
            @RequestBody UserEntity userEntity) {
        UserEntity user = usersService.updateAll(userEntity, id);
        return ResponseEntity.ok().body(user.getEmail() + " has be changes");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Integer id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok().body( "User with id number - " + id + " has be delete");
    }

}
