package com.example.jixly.util;

import java.net.HttpURLConnection;
import java.net.URL;

public class UrlChecker {
    public static boolean isUrlValid(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            connection.disconnect();

            return (200 <= responseCode && responseCode <= 399);
        } catch (Exception e) {
            return false;
        }
    }
}
