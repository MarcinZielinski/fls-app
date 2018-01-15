package com.fls.forum.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JsonParser<T> {


    private final Class<T> typeParameterClass;

    public JsonParser(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }


    public List<T> getObjectList(String json) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(json,
                    new TypeReference<LinkedList<T>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            return new LinkedList<T>();
        }
    }

    public T getObject(String json) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(json, typeParameterClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
