package com.project.entertainment.jsondata;

public class Trending {
    private String small;
    private String large;

    // Default constructor
    public Trending() {
    }

    // Parameterized constructor
    public Trending(String small, String large) {
        this.small = small;
        this.large = large;
    }

    // Getter and setters
    public String getSmall() {
        return this.small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return this.large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
