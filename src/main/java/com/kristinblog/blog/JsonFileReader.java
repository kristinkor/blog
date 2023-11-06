package com.kristinblog.blog;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kristinblog.blog.models.Project;

import java.io.InputStream;
import java.util.List;

public class JsonFileReader {
    public static List<Project> readProjectData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = JsonFileReader.class.getResourceAsStream("/data.json"); // Load JSON file
            if (inputStream != null) {
                System.out.println("JSON data has been loaded successfully.");
                // Proceed with further processing of the JSON data
            } else {
                System.out.println("Failed to load JSON data.");
                // Handle the case where JSON data couldn't be loaded
            }
            return objectMapper.readValue(inputStream, new TypeReference<List<Project>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the exception appropriately
        }
    }



}
