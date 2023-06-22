package com.project.entertainment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entertainment.jsondata.Regular;
import com.project.entertainment.jsondata.Thumbnail;
import com.project.entertainment.jsondata.Title;
import com.project.entertainment.jsondata.Trending;

@Service
public class TitlesService {

    @Autowired
    private final TitlesRepository titlesRepository;

    @Autowired
    private final BookmarkService bookmarkService;

    public TitlesService(TitlesRepository titlesRepository, BookmarkService bookmarkService) {
        this.titlesRepository = titlesRepository;
        this.bookmarkService = bookmarkService;
    }

    public List<Title> getCompleteTitlesByUser(User user) {
        List<Title> titles = new ArrayList<>();
        List<Titles> allTitles = titlesRepository.findAll();

        for (Titles title : allTitles) {

            // Check if title is bookmarked
            boolean isBoomarked = bookmarkService.checkBookmarkExists(user,
                    titlesRepository.findByName(title.getName()));

            // Creates title and adds it to the list
            Trending trending = new Trending(title.getTrendingSmall(), title.getTrendingLarge());
            Regular regular = new Regular(title.getRegularSmall(), title.getRegularMedium(),
                    title.getRegularLarge());

            Thumbnail thumbnail = new Thumbnail(trending, regular);

            titles.add(new Title(title.getName(), thumbnail, (int) title.getYear(), title.getCategory(),
                    title.getRating(),
                    isBoomarked, title.getIsTrending()));
        }

        return titles;
    }

    public List<Title> convertToTitleResponse(List<Titles> allTitles, User user) {
        List<Title> titles = new ArrayList<>();

        for (Titles title : allTitles) {

            // Check if title is bookmarked
            boolean isBoomarked = bookmarkService.checkBookmarkExists(user,
                    titlesRepository.findByName(title.getName()));

            // Creates title and adds it to the list
            Trending trending = new Trending(title.getTrendingSmall(), title.getTrendingLarge());
            Regular regular = new Regular(title.getRegularSmall(), title.getRegularMedium(),
                    title.getRegularLarge());

            Thumbnail thumbnail = new Thumbnail(trending, regular);

            titles.add(new Title(title.getName(), thumbnail, (int) title.getYear(), title.getCategory(),
                    title.getRating(),
                    isBoomarked, title.getIsTrending()));
        }

        return titles;
    }

    public List<Titles> searchTitles(String keyword) {
        List<Titles> titles = titlesRepository.findByNameContainingIgnoreCase(keyword);

        return titles;
    }
}
