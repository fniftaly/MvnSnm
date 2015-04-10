/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.properti;

/**
 *
 * @author def
 */
import java.io.*;
import java.util.*;

public class AppProperties {
    
    private static Map <String,String> properties = new HashMap<>();

    public static Map<String,String> getProperties() {
        try {
            Properties prpt = new Properties();
            // load the properties file using load() and an input stream
            FileInputStream in = new FileInputStream("/Users/def/NetBeansProjects/MvnSnm/src/main/java/app.properties");
            prpt.load(in);
            in.close();
            // iterate properties file to get key-value pairs
            for (String key : prpt.stringPropertyNames()) {
                
                String value = prpt.getProperty(key);
                
                properties.put(key, value);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return properties;
    }
}
