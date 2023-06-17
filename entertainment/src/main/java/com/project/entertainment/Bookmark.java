package com.project.entertainment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKMARK")
public class Bookmark {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Titles titles;

    Bookmark() {
    }

    Bookmark(User user, Titles titles) {
        this.user = user;
        this.titles = titles;
    }

    // Getters and setters
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Titles getTitles() {
        return this.titles;
    }

    public void setTitles(Titles titles) {
        this.titles = titles;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
