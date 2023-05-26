package com.project.entertainment.jsondata;

import java.util.List;

public class TitlesList {
    private List<Title> titles;

    // Default constructor
    public TitlesList() {
    }

    // Parameterized constructor
    public TitlesList(List<Title> titles) {
        this.titles = titles;
    }

    // Getter and setters for titles
    public List<Title> getTitles() {
        return this.titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }
}
