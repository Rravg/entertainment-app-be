package com.project.entertainment.jsondata;

public class Regular {
    private String small;
    private String medium;
    private String large;

    // Default constructor
    public Regular() {
    }

    // Parameterized constructor
    public Regular(String small, String medium, String large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    // Getter and setters
    public String getSmall() {
        return this.small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return this.medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return this.large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
