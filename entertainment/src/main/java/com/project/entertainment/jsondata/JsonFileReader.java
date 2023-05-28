package com.project.entertainment.jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class JsonFileReader {

    @Autowired
    private final ResourceLoader resourceLoader;

    public JsonFileReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<Title> readJsonFile() {
        try {
            Resource resource = resourceLoader.getResource("classpath:data.json");
            InputStream inputStream = resource.getInputStream();

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Title>> typeReference = new TypeReference<List<Title>>() {
            };
            List<Title> titles = objectMapper.readValue(inputStream, typeReference);

            // Process the list of TitlesList objects as needed
            return titles;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
