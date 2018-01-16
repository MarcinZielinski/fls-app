package com.fls.profiles.controller;

import com.fls.profiles.model.IUser;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class InfoController {
    private IUser user;

    @FXML
    private Text infFirstnameField;

    @FXML
    private Text infLastnameField;

    @FXML
    private Text infBirthdateField;

    @FXML
    private ImageView infImageField;

    @FXML
    private void initialize(){
    }

    public void setUser(IUser user){
        this.user = user;
        infFirstnameField.textProperty().bindBidirectional(user.getFirstnameProperty());
        infLastnameField.textProperty().bindBidirectional(user.getLastnameProperty());
        infBirthdateField.textProperty().bindBidirectional(user.getBirthdateProperty());
        infImageField.imageProperty().bindBidirectional(user.getImageProperty());
    }
}
