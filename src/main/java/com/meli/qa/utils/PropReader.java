package com.meli.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropReader {

    private PropReader() {
    }

    public static String getProperty(String propertyName) {

        Properties prop = new Properties();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(propertyName);
    }

}
