package com.project.entertainment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entertainment.jsondata.Title;

@RestController
public class BookMarkController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TitlesRepository titlesRepository;

    @Autowired
    private TitlesService titlesService;

    @Autowired
    private BookmarkService bookmarkService;

    @CrossOrigin
    @PutMapping("/bookmark")
    ResponseEntity<List<Title>> BookmarkTitle(@RequestBody Map<String, Object> requestBody) {
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

        List<Title> titles = new ArrayList<>();
        titles = titlesService.getCompleteTitlesByUser(user, title.getIsTrending());

        return new ResponseEntity<>(titles, HttpStatus.OK);
    }
}
