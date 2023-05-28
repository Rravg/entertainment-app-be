package com.project.entertainment;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.entertainment.jsondata.JsonFileReader;
import com.project.entertainment.jsondata.Title;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private final TitlesRepository titlesRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private Environment environment;

    @Autowired
    private final JsonFileReader jsonFileReader;

    public DatabaseLoader(TitlesRepository repository, UserRepository userRepository, JsonFileReader jsonFileReader) {
        this.titlesRepository = repository;
        this.userRepository = userRepository;
        this.jsonFileReader = jsonFileReader;
    }

    @Override
    public void run(String... strings) throws Exception {
        // Loads admin user from admin.user and admin.password properties
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10, new SecureRandom());
        String encodedPassword = encoder.encode(environment.getProperty("admin.password"));
        this.userRepository.save(new User(environment.getProperty("admin.user"), encodedPassword));

        // Loads original titles
        List<Title> titles = jsonFileReader.readJsonFile();
        for (Title title : titles) {
            if (title.getTrending()) {
                this.titlesRepository.save(new Titles(
                        title.getTitle(),
                        title.getYear(),
                        title.getCategory(),
                        title.getRating(),
                        title.getTrending(),
                        title.getThumbnail().getTrending().getSmall(),
                        title.getThumbnail().getTrending().getLarge(),
                        title.getThumbnail().getRegular().getSmall(),
                        title.getThumbnail().getRegular().getMedium(),
                        title.getThumbnail().getRegular().getLarge()));
            } else {
                this.titlesRepository.save(new Titles(
                        title.getTitle(),
                        title.getYear(),
                        title.getCategory(),
                        title.getRating(),
                        title.getTrending(),
                        title.getThumbnail().getRegular().getSmall(),
                        title.getThumbnail().getRegular().getMedium(),
                        title.getThumbnail().getRegular().getLarge()));
            }

        }
    }
}
