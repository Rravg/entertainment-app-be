package com.project.entertainment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public void login(@RequestBody User newUser) {
        System.out.println("login attempt with new User:");
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public void signout(@RequestBody User newUser) {
        System.out.println("sign up attempt:");
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/logout")
    public void logout() {
        System.out.println("logout user");
    }
}
