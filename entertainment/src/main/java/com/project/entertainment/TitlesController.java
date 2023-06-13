package com.project.entertainment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TitlesController {

    @Autowired
    private TitlesRepository titlesRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/titles")
    ResponseEntity<List<Titles>> all() {
        List<Titles> titles = new ArrayList<>();
        titles.addAll(titlesRepository.findAll());

        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/trending")
    ResponseEntity<List<Titles>> trending() {
        List<Titles> titles = new ArrayList<>();
        List<Titles> allTitles = titlesRepository.findAll();
        for (Titles title : allTitles) {
            if (title.getIsTrending()) {
                titles.add(title);
            }
        }

        return new ResponseEntity<>(titles, HttpStatus.OK);
    }
}
