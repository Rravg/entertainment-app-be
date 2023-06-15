package com.project.entertainment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entertainment.jsondata.Title;

@RestController()
public class TitlesController {

    @Autowired
    private TitlesRepository titlesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TitlesService titlesService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/titles")
    ResponseEntity<List<Titles>> all() {
        List<Titles> titles = new ArrayList<>();
        titles.addAll(titlesRepository.findAll());

        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/trending")
    ResponseEntity<List<Title>> trending(@RequestBody Map<String, Object> requestBody) {
        // Deserialize email
        String email = (String) requestBody.get("email");
        User user = userRepository.findByEmail(email);

        List<Title> titles = new ArrayList<>();
        titles = titlesService.getCompleteTitlesByUser(user);
        
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }
}
