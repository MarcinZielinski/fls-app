package com.fls.forum.model;

import com.fls.forum.model.serverModel.SectionServer;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

public class ServerObjectController<T> {

    private String urlPrefix = "http://localhost:8080/";

    private final Class<T> typeParameterClass;
    JsonParser<T> jsonParser;

    public ServerObjectController(Class<T> typeParameterClass) {

        this.typeParameterClass = typeParameterClass;
        jsonParser = new JsonParser<>(typeParameterClass);
    }

    public List<T> getItemList(String query){
        try {
            URL oracle = new URL(urlPrefix + query);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = in.readLine();

            System.out.println(inputLine);

            List<T> items = jsonParser.getObjectList(inputLine);

            in.close();

            return items;

        } catch (IOException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }
    }

    public T getItem(String query){
        try {
            URL oracle = new URL(urlPrefix + query);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = in.readLine();

            T item = jsonParser.getObject(inputLine);
            in.close();

            return item;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void createItem(T item, String query){
        try {
            URL oracle = new URL(urlPrefix + query + jsonParser.parseObject(item));
            URLConnection yc = oracle.openConnection();

            System.out.println("sending new object to server");

            HttpURLConnection http = (HttpURLConnection)yc;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);
            http.connect();
            try(OutputStream os = http.getOutputStream()) {
                os.write(12);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
