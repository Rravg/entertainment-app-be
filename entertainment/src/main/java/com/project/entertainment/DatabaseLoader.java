package com.project.entertainment;

import org.springframework.stereotype.Component;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entertainment.jsondata.Title;
import com.project.entertainment.jsondata.TitlesList;

import java.io.IOException;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final ResourceLoader resourceLoader;

    @Autowired
    private final TitlesRepository repository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private Environment environment;

    public DatabaseLoader(TitlesRepository repository, UserRepository userRepository, ResourceLoader resourceLoader) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(String... strings) throws Exception {
        // Loads admin user from admin.user and admin.password properties
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10, new SecureRandom());
        String encodedPassword = encoder.encode(environment.getProperty("admin.password"));
        this.userRepository.save(new User(environment.getProperty("admin.user"), encodedPassword));

        // Loads original titles
        try {
            Resource resource = resourceLoader.getResource("classpath:data.json");
            Path filePath = resource.getFile().toPath();
            byte[] jsonData = Files.readAllBytes(filePath);
            ObjectMapper objectMapper = new ObjectMapper();
            TitlesList titlesList = objectMapper.readValue(jsonData, TitlesList.class);

            // Acess the list of titles
            List<Title> titles = titlesList.getTitles();

            // Iterate through the titles
            for (Title title : titles) {
                System.out.println(title);
            }

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
