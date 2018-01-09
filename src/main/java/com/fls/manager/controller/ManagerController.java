package com.fls.manager.controller;

import com.fls.manager.Manager;
import com.fls.manager.SideBar;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by Marcin on 2017-12-12.
 */
public class ManagerController {
    @FXML
    public TextField searchUserField;
    public BorderPane borderPane;
    public Button undoButton;
    public Button redoButton;

    private Manager model;
    private SideBar sideBar;
    private Pane sidePane;

    @FXML
    public void initialize() {
        sideBar = new SideBar(100, new Button("Wall"), new Button("Chat"), new Button("Forum"), new Button("Your Profile"));
        sidePane = new Pane();
        sidePane.setPrefWidth(20);
        sidePane.setStyle("-fx-background-color: lightgray");
        HBox sideHBox = new HBox(sideBar, sidePane);
        sideHBox.setOnMouseEntered(this::openSideBar);
        sideHBox.setOnMouseExited(this::hideSideBar);
        borderPane.setLeft(sideHBox);
    }

    @FXML
    public Button searchButton;

    public Manager getModel() {return model;}
    public void setModel(Manager model) {this.model = model;}

    public void searchForUsers(ActionEvent event) {
        model.loadUserFinder(searchUserField.getText());
    }

    public void logout(ActionEvent actionEvent) {
        model.logout();
    }

    public void undoPage(ActionEvent actionEvent) {
        model.undo();
    }

    public void redoPage(ActionEvent actionEvent) {
        model.redo();
    }

    public void logoClicked(MouseEvent mouseEvent) {
        model.loadWall();
    }

    public void setBindings(IntegerProperty undoStackState, IntegerProperty redoStackState) {
        undoButton.disableProperty().bind(undoStackState.isEqualTo(1));
        redoButton.disableProperty().bind(redoStackState.isEqualTo(0));
    }

    public void openSideBar(MouseEvent mouseEvent) {
        sideBar.open();
    }

    public void hideSideBar(MouseEvent mouseEvent) {
        sideBar.close();
    }
}
