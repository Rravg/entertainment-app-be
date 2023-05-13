package com.project.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void login(@RequestBody User user) {
        System.out.println("login attempt with new User:");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println("");

        User foundUser = userRepository.findByEmail(user.getEmail());

        System.out.println(foundUser.getEmail());
        System.out.println(foundUser.getPassword());

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public void signout(@RequestBody User user) {
        System.out.println("Sign Up user with new User:");

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        userRepository.save(newUser);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/logout")
    public void logout() {
        System.out.println("logout user");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getall")
    public void getAll() {
        System.out.println("---> get all mapping found: ");
        System.out.println(userRepository);
    }

}
