package org.example.careerintelligence.service;

import org.example.careerintelligence.model.User;
import org.example.careerintelligence.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Save User
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}