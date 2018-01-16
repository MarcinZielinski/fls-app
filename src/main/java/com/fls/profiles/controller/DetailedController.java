package com.fls.profiles.controller;

import com.fls.profiles.model.IUser;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class DetailedController {
    IUser user;

    @FXML
    private Text detFirstnameField;

    @FXML
    private Text detLastnameField;

    @FXML
    private Text detBirthdateField;

    @FXML
    private Text detEmailField;

    @FXML
    private Text detPhoneField;

    @FXML
    private Text detAddressField;

    @FXML
    private Text detCityField;

    @FXML
    private Text detCountryField;

    @FXML
    private ImageView detImageField;

    @FXML
    private void initialize(){
    }

    public void setUser(IUser user){
        this.user = user;
        detFirstnameField.textProperty().bindBidirectional(user.getFirstnameProperty());
        detLastnameField.textProperty().bindBidirectional(user.getLastnameProperty());
        detBirthdateField.textProperty().bindBidirectional(user.getBirthdateProperty());
        detEmailField.textProperty().bindBidirectional(user.getEmailProperty());
        detPhoneField.textProperty().bindBidirectional(user.getPhoneProperty());
        detAddressField.textProperty().bindBidirectional(user.getAddressProperty());
        detCountryField.textProperty().bindBidirectional(user.getCountryProperty());
        detCityField.textProperty().bindBidirectional(user.getCityProperty());
        detImageField.imageProperty().bindBidirectional(user.getImageProperty());
    }
}
