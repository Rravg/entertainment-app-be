package com.project.entertainment.jsondata;

public class Title {

    private String title;
    private Thumbnail thumbnail;
    private int year;
    private String category;
    private String rating;
    private boolean bookmarked;
    private boolean trending;

    // Default constructor
    public Title() {
    }

    // Parameterized constructor
    public Title(String title, Thumbnail thumbnail, int year, String category, String rating, boolean bookmarked,
            boolean trending) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.year = year;
        this.category = category;
        this.rating = rating;
        this.bookmarked = bookmarked;
        this.trending = trending;
    }

    // Getter and setters
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isBookmarked() {
        return this.bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public boolean isTrending() {
        return this.trending;
    }

    public void setTrending(boolean trending) {
        this.trending = trending;
    }
}
