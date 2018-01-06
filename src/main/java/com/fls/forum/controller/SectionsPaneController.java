package com.fls.forum.controller;

import com.fls.forum.model.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.io.IOException;
import java.util.*;

public class SectionsPaneController {

    @FXML
    private ListView<Section> sectionsListView = new ListView<>();
    private ObservableList<Section> nameList;

    public SectionsPaneController(){

    }

    private void setSectionsListView(){
        List<Section> sections = new dataGenerator().getSections();
        nameList = FXCollections.observableArrayList(sections);
        sectionsListView.setItems(nameList);
        sectionsListView.setOnMouseClicked(mouseEvent -> System.out.println(sectionsListView.getSelectionModel().getSelectedItem()));
    }

    @FXML
    void initialize(){
        setSectionsListView();
    }
}


