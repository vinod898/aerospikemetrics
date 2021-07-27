package com.shris.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.shris.domain.User;
import com.shris.repo.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public Optional<User> readUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    public void removeUserById(int id) {
        userRepository.removeUserById(id);
    }
}
