package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] content = new String[0];
        try {
            content = Files.readString(file.toPath()).split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> contentMap = new HashMap<>();
        for (String s : content) {
            String[] pair = s.split(":");
            contentMap.put(pair[0], pair[1].trim());
        }

        return new Profile(
                contentMap.get("Name"),
                Integer.parseInt(contentMap.get("Age")),
                contentMap.get("Email"),
                Long.parseLong(contentMap.get("Phone"))
        );
    }
}