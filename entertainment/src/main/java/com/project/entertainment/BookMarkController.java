package com.project.entertainment;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookMarkController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TitlesRepository titlesRepository;

    // @Autowired
    // private final BookmarkRepository bookmarkRepository;

    @Autowired
    private BookmarkService bookmarkService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/bookmark")
    void BookmarkTitle(@RequestBody Map<String, Object> requestBody) {
        System.out.println("Bookmark enpoint reached");
        String name = (String) requestBody.get("name");
        String email = (String) requestBody.get("email");
        System.out.println("Title: " + name);
        System.out.println("User: " + email);

        User user = userRepository.findByEmail(email);
        Titles title = titlesRepository.findByName(name);

        bookmarkService.addBookmark(user, title);
    }
}
