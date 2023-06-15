package com.project.entertainment;

import java.util.List;
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

    @Autowired
    private BookmarkService bookmarkService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/bookmark")
    void BookmarkTitle(@RequestBody Map<String, Object> requestBody) {
        // Deserialize name and email address
        String name = (String) requestBody.get("name");
        String email = (String) requestBody.get("email");

        // Get user and Title
        User user = userRepository.findByEmail(email);
        Titles title = titlesRepository.findByName(name);

        // Check if bookmark already exists
        if (bookmarkService.checkBookmarkExists(user, title)) {

            // Remove Bookmark
            Long id = bookmarkService.getBookmardId(user, title);
            bookmarkService.removeBookmark(id);
        } else {

            // Add bookmark
            bookmarkService.addBookmark(user, title);
        }
    }
}
