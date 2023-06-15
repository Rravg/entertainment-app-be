package com.project.entertainment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {

    @Autowired
    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public Bookmark addBookmark(User user, Titles titles) {
        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);
        bookmark.setTitles(titles);
        return bookmarkRepository.save(bookmark);
    }

    public void removeBookmark(Long bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }

    public List<Bookmark> getBookmarksByUser(User user) {
        return bookmarkRepository.findByUser(user);
    }

    public boolean checkBookmarkExists(User user, Titles title) {
        return bookmarkRepository.existsByUserAndTitles(user, title);
    }

    public Long getBookmardId(User user, Titles title) {
        Bookmark bookmark = bookmarkRepository.findByUserAndTitles(user, title);
        return bookmark.getId();
    }
}
