package com.practice4.practice.controller;



import com.practice4.practice.entity.UserEntity;
import com.practice4.practice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/")
    public ResponseEntity<String> setSignUp(@RequestBody UserEntity user){
        if(user == null || user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Invalid user data");
        }

        // Check if the user exists in the database
        boolean userExists = repo.existsByUsername(user.getUsername());
        boolean passwordMatches = repo.existsByPassword(passwordEncoder.encode(user.getPassword()));

        if(userExists) {
            return ResponseEntity.badRequest().body("User with this username already exists");
        } else if (passwordMatches) {
            return ResponseEntity.badRequest().body("Password matches with an existing user");
        } else {
            // Encode the password before saving to the database
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repo.save(user);
            return ResponseEntity.ok("User created successfully");
        }
    }
}
