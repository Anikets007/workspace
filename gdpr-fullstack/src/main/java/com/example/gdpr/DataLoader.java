package com.example.gdpr;

import com.example.gdpr.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        // create default admin if not exists (username: admin, password: password)
        if (!userService.findByUsername("admin").isPresent()) {
            userService.create("admin", "password", "ROLE_ADMIN");
            System.out.println("Created default admin user (admin/password) - change in production");
        }
    }
}
