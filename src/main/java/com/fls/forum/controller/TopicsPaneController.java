package com.fls.forum.controller;

import com.fls.forum.model.Topic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TopicsPaneController implements Initializable{

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

    public void changeScreenBackButtonClicked(javafx.event.ActionEvent event) throws IOException {
        Parent sectionsParent = FXMLLoader.load(getClass().getResource("../pane_sections.fxml"));
        Scene scene = new Scene(sectionsParent);

        Stage window = (Stage)((((Node)event.getSource())).getScene().getWindow());
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTopicsListView();
    }
}
