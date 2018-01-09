package com.fls.manager.controller;

import com.fls.manager.Manager;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

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

    @FXML
    public void initialize() throws IOException {
        borderPane.setLeft(loadSideMenu());
    }

    private HBox loadSideMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/fls/manager/pane_side_menu.fxml"));
        HBox sideHBox = fxmlLoader.load();
        SideMenuController sideMenuController = fxmlLoader.getController();
        Platform.runLater(() -> sideMenuController.setModel(model)); // later. First we need to obtain a model ourselves
        return sideHBox;
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
}
