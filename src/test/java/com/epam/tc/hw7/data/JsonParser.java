package com.epam.tc.hw7.data;

import com.epam.tc.hw7.model.MetalsAndColors;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {
    public static Map<String, MetalsAndColors> convertJsonToMap(String path) {
        Map<String, MetalsAndColors> dataFromJson = new HashMap<>();
        try {
            Type type = new TypeToken<HashMap<String, MetalsAndColors>>() {
            }.getType();
            dataFromJson = new Gson().fromJson(new FileReader(path), type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataFromJson;
    }

}
