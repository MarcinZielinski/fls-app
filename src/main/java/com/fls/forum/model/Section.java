package com.fls.forum.model;


import java.util.List;

public class Section {
    private long id;
    private String name;
    private String description;

    public Section(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    private List<Integer> getAllPostIds(){
        return null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
