package com.fls.manager.controller;

import com.fls.manager.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Marcin on 2017-12-12.
 */
public class ManagerController {
    @FXML
    public TextField searchUserField;
    @FXML
    public Button searchButton;
    @FXML
    public Button chatButton;

    private Manager model;

    @FXML
    public void initialize() {
    }

    public Manager getModel() {
        return model;
    }

    public void setModel(Manager model) {
        this.model = model;
    }

    public void searchForUsers(ActionEvent event) {
        model.loadUserFinder(searchUserField.getText());
    }

    public void openChat() {
        model.loadChat();
    }

}
