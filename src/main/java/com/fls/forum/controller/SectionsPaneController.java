package com.fls.forum.controller;

import com.fls.forum.model.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SectionsPaneController implements Initializable {

    @FXML
    private ListView<Section> sectionsListView = new ListView<>();
    private ObservableList<Section> nameList;
    private ApplicationController applicationController;

    public SectionsPaneController(){

    }

    private void setSectionsListView(){
        List<Section> sections = new dataGenerator().getSections();
        nameList = FXCollections.observableArrayList(sections);
        sectionsListView.setItems(nameList);
        sectionsListView.setOnMouseClicked(mouseEvent -> {
            try {
                changeScreenSectionSelected((Node)mouseEvent.getSource());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void changeScreenSectionSelected(Node source) throws IOException {
//        TopicsPaneController topicsPaneController = new TopicsPaneController(sectionsListView.getSelectionModel().getSelectedItem());
//        topicsPaneController.setApplicationController(applicationController);

        applicationController.loadTopicsPane(sectionsListView.getSelectionModel().getSelectedItem());
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../pane_topics.fxml"));
//        loader.setController(topicsPaneController);
//        Parent sectionsParent = loader.load();
//        Scene scene = new Scene(sectionsParent);
//
//        Stage window = (Stage)(source.getScene().getWindow());
//        window.setScene(scene);
//        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSectionsListView();
    }

    public void setApplicationController(ApplicationController applicationController) {
        System.out.println("setting controller");
        this.applicationController = applicationController;
    }
}


