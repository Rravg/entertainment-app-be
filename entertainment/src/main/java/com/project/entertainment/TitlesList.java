package com.project.entertainment;

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

    public List<Title> getTitles() {
        return titles;
    }
}
