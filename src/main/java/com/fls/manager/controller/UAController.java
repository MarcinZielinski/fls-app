package com.fls.manager.controller;

import com.fls.user_authentication.UserAuthentication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Marcin on 2017-12-18.
 */
public class UAController {
    private UserAuthentication model;

    @FXML
    public Button loginButton;

    @FXML
    void initialize() {}

    public void login(ActionEvent event) {
        model.login(0L,0L);
    }

    public void setModel(UserAuthentication model) {
        this.model = model;
    }
}
