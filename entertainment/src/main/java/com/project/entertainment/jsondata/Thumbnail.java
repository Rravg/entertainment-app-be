package com.project.entertainment.jsondata;

public class Thumbnail {
    private Trending trending;
    private Regular regular;

    // Default constructor
    public Thumbnail() {
    }

    // Parameterized constructor
    public Thumbnail(Trending trending, Regular regular) {
        this.trending = trending;
        this.regular = regular;
    }

    // Getter and setters
    public Trending getTrending() {
        return this.trending;
    }

    public void setTrending(Trending trending) {
        this.trending = trending;
    }

    public Regular getRegular() {
        return this.regular;
    }

    public void setRegular(Regular regular) {
        this.regular = regular;
    }
}
