package com.project.entertainment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUser(User user);

    boolean existsByUserAndTitles(User user, Titles title);

    Bookmark findByUserAndTitles(User user, Titles title);
}
