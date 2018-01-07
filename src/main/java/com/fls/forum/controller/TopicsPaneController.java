package com.fls.forum.controller;

import com.fls.forum.model.Topic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.util.List;

public class TopicsPaneController{

    private long currentSectionId;
    @FXML
    private ListView<Topic> topicsListView = new ListView<>();
    private ObservableList<Topic> nameList;

    public TopicsPaneController(){

    }

    private void setTopicsListView(){
        List<Topic> topics = new dataGenerator().getTopics(1);
        nameList = FXCollections.observableArrayList(topics);
        topicsListView.setItems(nameList);
        topicsListView.setOnMouseClicked(mouseEvent -> System.out.println(topicsListView.getSelectionModel().getSelectedItem()));
    }

    @FXML
    void initialize(){
        setTopicsListView();
    }
}
