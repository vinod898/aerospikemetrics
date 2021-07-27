package com.shris.controllers;


import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shris.domain.User;
import com.shris.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("/users/{id}")
    public Optional<User> readUserById(@PathVariable("id") Integer id) {
        return userService.readUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
    }
}
