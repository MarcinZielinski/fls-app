package com.fls.forum.model;


import com.fls.forum.controller.dataGenerator;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private long id;
    private String name;
    private String description;
    private List<Topic> topics;


    public Section(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        //TODO: get from server
        topics = dataGenerator.getTopics(id);
        for(Topic topic: topics)
            topic.setSection(this);

    }

    public void loadTopics(){
        //TODO: get from sever

    }

    public void setTopics(List<Topic> topics){
        this.topics = topics;
    }

    public List<Topic> getTopics(){
        //TODO: get rom server
        return topics;
    }

    public void addTopic(Topic topic){
        this.topics.add(topic);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format("%-25s", name) + description;
    }
}