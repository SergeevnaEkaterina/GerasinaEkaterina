package com.epam.tc.hw3.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyInitialization {

    public static String getPropertyByName(String name) {
        FileInputStream fis;
        String properties = null;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/hw2/configuration.properties");
            property.load(fis);
            properties = property.getProperty(name);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return properties;
    }
}
