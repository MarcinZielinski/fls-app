package com.fls.forum.controller;

import com.fls.forum.model.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SectionsPaneController implements Initializable {

    @FXML
    private ListView<Section> sectionsListView = new ListView<>();
    private ObservableList<Section> nameList;

    public SectionsPaneController(){

    }

    private void setSectionsListView(){
        List<Section> sections = new dataGenerator().getSections();
        nameList = FXCollections.observableArrayList(sections);
        sectionsListView.setItems(nameList);
        sectionsListView.setOnMouseClicked(mouseEvent -> {
            try {
                changeScreenSectonSelected((Node)mouseEvent.getSource());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

//    @FXML
//    void initialize(){
//        setSectionsListView();
//    }

    public void changeScreenSectonSelected(Node source) throws IOException {
        System.out.println(getClass());
        Parent sectionsParent = FXMLLoader.load(getClass().getResource("../pane_topics.fxml"));
        Scene scene = new Scene(sectionsParent);

        Stage window = (Stage)(source.getScene().getWindow());
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSectionsListView();
    }
}


