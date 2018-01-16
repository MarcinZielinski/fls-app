package com.fls.profiles.controller;

import com.fls.profiles.Profile;
import com.fls.profiles.model.IUser;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ProfileController {
    private IUser user;
    private Profile profile;

    @FXML
    private Text firstnameField;

    @FXML
    private Text lastnameField;

    @FXML
    private Text birthdateField;

    @FXML
    private Text emailField;

    @FXML
    private Text phoneField;

    @FXML
    private Text addressField;

    @FXML
    private Text cityField;

    @FXML
    private Text countryField;

    @FXML
    private ListView<String> spokenLanguagesList;

    @FXML
    private ListView<String> programmingLanguagesList;

    @FXML
    private Text experienceField;

    @FXML
    private Text flsPointsField;

    @FXML
    private Text stackPointsField;

    @FXML
    private Text hackerrankPointsField;

    @FXML
    private ImageView imageField;

    @FXML
    private AnchorPane friend1Pane;

    @FXML
    private AnchorPane friend2Pane;

    @FXML
    private void initialize(){
        firstnameField.textProperty().addListener((ov, oldVal, newVal) -> firstnameField.setText(newVal));
        lastnameField.textProperty().addListener((ov, oldVal, newVal) -> lastnameField.setText(newVal));
        birthdateField.textProperty().addListener((ov, oldVal, newVal) -> birthdateField.setText(newVal));
        emailField.textProperty().addListener((ov, oldVal, newVal) -> emailField.setText(newVal));
        phoneField.textProperty().addListener((ov, oldVal, newVal) -> phoneField.setText(newVal));
        addressField.textProperty().addListener((ov, oldVal, newVal) -> addressField.setText(newVal));
        cityField.textProperty().addListener((ov, oldVal, newVal) -> cityField.setText(newVal));
        countryField.textProperty().addListener((ov, oldVal, newVal) -> countryField.setText(newVal));
        experienceField.textProperty().addListener((ov, oldVal, newVal) -> experienceField.setText(newVal));
        stackPointsField.textProperty().addListener((ov, oldVal, newVal) -> stackPointsField.setText(newVal));
        hackerrankPointsField.textProperty().addListener((ov, oldVal, newVal) -> hackerrankPointsField.setText(newVal));
        imageField.imageProperty().addListener((ov, oldVal, newVal) -> imageField.setImage(newVal));
        flsPointsField.textProperty().addListener((ov, oldVal, newVal) -> flsPointsField.setText(newVal));
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setUser(IUser user){
        this.user = user;
        firstnameField.textProperty().bindBidirectional(user.getFirstnameProperty());
        lastnameField.textProperty().bindBidirectional(user.getLastnameProperty());
        birthdateField.textProperty().bindBidirectional(user.getBirthdateProperty());
        emailField.textProperty().bindBidirectional(user.getEmailProperty());
        phoneField.textProperty().bindBidirectional(user.getPhoneProperty());
        addressField.textProperty().bindBidirectional(user.getAddressProperty());
        countryField.textProperty().bindBidirectional(user.getCountryProperty());
        cityField.textProperty().bindBidirectional(user.getCityProperty());
        experienceField.textProperty().bindBidirectional(user.getExperienceProperty());
        flsPointsField.textProperty().bindBidirectional(user.getFlsPointsProperty());
        stackPointsField.textProperty().bindBidirectional(user.getStackPointsProperty());
        hackerrankPointsField.textProperty().bindBidirectional(user.getHackerrankPointsProperty());
        imageField.imageProperty().bindBidirectional(user.getImageProperty());
        spokenLanguagesList.setItems(FXCollections.observableArrayList(user.getSpokenLanguages()));
        programmingLanguagesList.setItems(FXCollections.observableArrayList(user.getProgrammingLanguages()));
        ArrayList<Long> friends = user.getFriends();
        if(!friends.isEmpty()){
            friend1Pane.getChildren().add(profile.getInfo(friends.get(0)));
            if(friends.size() > 1){
                friend2Pane.getChildren().add(profile.getInfo(friends.get(1)));
            }
        }
    }

    public void editProfile(){
        profile.editDialog(profile.manager.userId);
    }
}
