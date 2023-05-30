package com.project.entertainment;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TITLES")
public class Titles {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    private String name;
    private Number year_;
    private String category;
    private String rating;
    private Boolean isTrendig;

    private String trendingSmall;
    private String trendingLarge;

    private String regularSmall;
    private String regularMedium;
    private String regularLarge;

    @OneToMany(mappedBy = "titles", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks = new ArrayList<>();

    Titles() {
    }

    Titles(String name, Number year, String category, String rating, Boolean isTrending, String regularSmall,
            String regularMedium, String regularLarge) {
        this.name = name;
        this.year_ = year;
        this.category = category; // May change to a custom type
        this.rating = rating; // May change to a custom type
        this.isTrendig = isTrending;

        this.trendingSmall = "";
        this.trendingLarge = "";

        this.regularSmall = regularSmall;
        this.regularMedium = regularMedium;
        this.regularLarge = regularLarge;
    }

    Titles(String name, Number year, String category, String rating, Boolean isTrending, String trendingSmall,
            String trendingLarge, String regularSmall, String regularMedium, String regularLarge) {
        this.name = name;
        this.year_ = year;
        this.category = category; // May change to a custom type
        this.rating = rating; // May change to a custom type
        this.isTrendig = isTrending;

        this.trendingSmall = trendingSmall;
        this.trendingLarge = trendingLarge;

        this.regularSmall = regularSmall;
        this.regularMedium = regularMedium;
        this.regularLarge = regularLarge;
    }

    public String getRegularLarge() {
        return this.regularLarge;
    }

    public void setRegularLarge(String regularLarge) {
        this.regularLarge = regularLarge;
    }

    public String getRegularMedium() {
        return this.regularMedium;
    }

    public void setRegularMedium(String regularMedium) {
        this.regularMedium = regularMedium;
    }

    public String getRegularSmall() {
        return this.regularSmall;
    }

    public void setRegularSmall(String regularSmall) {
        this.regularSmall = regularSmall;
    }

    public String getTrendingLarge() {
        return this.trendingLarge;
    }

    public void setTrendingLarge(String trendingLarge) {
        this.trendingLarge = trendingLarge;
    }

    public String getTrendingSmall() {
        return this.trendingSmall;
    }

    public void setTrendingSmall(String trendingSmall) {
        this.trendingSmall = trendingSmall;
    }
    //////

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getYear() {
        return this.year_;
    }

    public void setYear(Number year) {
        this.year_ = year;
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

    public Boolean getIsTrending() {
        return this.isTrendig;
    }

    public void setIsTrending(Boolean isTrending) {
        this.isTrendig = isTrending;
    }

}
