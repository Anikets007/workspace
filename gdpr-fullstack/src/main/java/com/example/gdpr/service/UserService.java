package com.example.gdpr.service;

import com.example.gdpr.entity.User;
import com.example.gdpr.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public User create(String username, String rawPassword, String role) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(rawPassword));
        u.setRole(role);
        return repo.save(u);
    }

    public boolean authenticate(String username, String rawPassword) {
        return findByUsername(username)
                .map(u -> passwordEncoder.matches(rawPassword, u.getPassword()))
                .orElse(false);
    }
}
