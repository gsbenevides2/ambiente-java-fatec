package com.gsbenevides2.poo.tarde.Utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MakeHttpRequest {
    public static String get(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        BufferedReader in = new BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        JSONObject json = new JSONObject(content.toString());
        return json.getString("resposta");
    }
}
