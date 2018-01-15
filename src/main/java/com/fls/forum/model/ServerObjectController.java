package com.fls.forum.model;

import com.fls.forum.model.serverModel.SectionServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

public class ServerObjectController<T> {

    private String urlPrefix = "http://localhost:8080/";

    private final Class<T> typeParameterClass;

    public ServerObjectController(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public List<T> getItemList(String query){
        try {
            URL oracle = new URL(urlPrefix + query);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = in.readLine();

            System.out.println(inputLine);

            List<T> items = new JsonParser<T>(typeParameterClass).getObjectList(inputLine);
            in.close();

            return items;

        } catch (IOException e) {
            e.printStackTrace();
            return new LinkedList<T>();
        }
    }

    public T getItem(String query){
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
            return null;
        }
    }

}
