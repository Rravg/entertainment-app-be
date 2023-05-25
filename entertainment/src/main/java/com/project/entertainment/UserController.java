package com.project.entertainment;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody User user) {
        // Get data
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();

        // Check if email exists in database
        if (userRepository.existsByEmail(userEmail)) {
            // Get user and compare passwords
            User foundUser = userRepository.findByEmail(userEmail);
            String encodedPassword = foundUser.getPassword();

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10, new SecureRandom());

            // Check if password match
            if (encoder.matches(userPassword, encodedPassword)) {
                // Send Ok response
                return new ResponseEntity<>("Logging in", HttpStatus.OK);

            } else {
                // Bad response check credentials
                return new ResponseEntity<>("Incorrect credentials", HttpStatus.BAD_REQUEST);
            }

        } else {
            // Bad response check credentials
            return new ResponseEntity<>("Incorrect credentials", HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    ResponseEntity<String> signup(@RequestBody User user) {
        // Get data
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();

        // Check if User already exists
        if (userRepository.existsByEmail(userEmail)) {
            // If email found, send bad response
            return new ResponseEntity<>("User ealready exists", HttpStatus.BAD_REQUEST);

        } else {
            // Hash Password
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10, new SecureRandom());
            String encodedPassword = encoder.encode(userPassword);

            // Saves user
            User newUser = new User(userEmail, encodedPassword);
            userRepository.save(newUser);

            // Notify user account has been created
            return new ResponseEntity<>("New account created", HttpStatus.OK);
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/logout")
    public void logout() {
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getall")
    public void getAll() {
        System.out.println("---> get all mapping found: ");
        for (User user : userRepository.findAll()) {
            System.out.println(user.getId());
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println("----------------------");
        }
    }

}
