package com.fls.forum.model;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

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

        TypeFactory typeFactory = mapper.getTypeFactory();

        JavaType inner = typeFactory.constructParametricType(List.class, typeParameterClass);


        try {
            return mapper.readValue(json,
                    inner);
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

    public String parseObject(T item){
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(item);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
