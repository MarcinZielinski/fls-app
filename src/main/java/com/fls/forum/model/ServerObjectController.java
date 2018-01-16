package com.fls.forum.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

public class ServerObjectController<T> {

    private final Class<T> typeParameterClass;
    private String urlPrefix = "http://localhost:8080/";

    public ServerObjectController(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public List<T> getItemList(String query) {
        try {
            URL oracle = new URL(urlPrefix + query);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = in.readLine();

            System.out.println(inputLine);

            List<T> items = new JsonParser<T>(typeParameterClass).getObjectList(inputLine);
            System.out.println(typeParameterClass);
            System.out.println(items.get(0).getClass());
            System.out.println(items.get(0));

            in.close();

            return items;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("encountered exception");
            return new LinkedList<>();
        }
    }

    public T getItem(String query) {
        try {
            URL oracle = new URL(urlPrefix + query);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = in.readLine();

            System.out.println(inputLine);

            T item = new JsonParser<T>(typeParameterClass).getObject(inputLine);
            in.close();

            return item;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("encountered exception");
            return null;
        }
    }

}
