package com.fls.profiles.controller;

import com.fls.profiles.model.IUser;
import com.fls.profiles.model.Programist;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class EditController {
    IUser current_user = new Programist();
    Stage stage;

    @FXML
    private TextField loginTField;

    @FXML
    private PasswordField passwordTField;

    @FXML
    private TextField firstnameTField;

    @FXML
    private TextField lastnameTField;

    @FXML
    private TextField birthdateTField;

    @FXML
    private TextField emailTField;

    @FXML
    private TextField phoneTField;

    @FXML
    private TextField addressTField;

    @FXML
    private TextField cityTField;

    @FXML
    private TextField countryTField;

    @FXML
    private TextField experienceTField;

    @FXML
    private TextField stackTField;

    @FXML
    private TextField hackerTField;

    @FXML
    private ListView<String> availSpoken = new ListView<>();

    @FXML
    private ListView<String> availProgramming = new ListView<>();

    @FXML
    private Button butImg;

    @FXML
    private ImageView imgView;

    @FXML
    private void initialize(){
        String[] langs = {"polish", "english", "spanish", "german", "french", "japanese", "chinese", "russian", "italian", "esperanto"};
        String[] programmings = {"c++", "c", "php", "java", "ruby", "python", "icon", "julia", "erlang", "lisp", "scala", "javascript"};
        availSpoken.setItems(FXCollections.observableArrayList(langs));
        availProgramming.setItems(FXCollections.observableArrayList(programmings));
    }

    public void ChooseImage(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null){
            imgView.setImage(new Image(selectedFile.toURI().toString()));
        }
    }

    public void save(){
        current_user.setLogin(loginTField.getText());
        current_user.setPassword(passwordTField.getText());
        current_user.setLastname(lastnameTField.getText());
        current_user.setFirstname(firstnameTField.getText());
        current_user.setBirthdate(birthdateTField.getText());
        current_user.setPhone(phoneTField.getText());
        current_user.setEmail(emailTField.getText());
        current_user.setAddress(addressTField.getText());
        current_user.setCity(cityTField.getText());
        current_user.setCountry(countryTField.getText());
        current_user.setExperience(Integer.valueOf(experienceTField.getText()));
        current_user.setStackPoints(Integer.valueOf(stackTField.getText()));
        current_user.setHackerrankPoints(Integer.valueOf(stackTField.getText()));
        current_user.setImage(imgView.getImage());
        stage.close();
    }

    public void discardChanges(){
        stage.close();
    }

    public void setUser(IUser user){
        current_user = user;
        availSpoken.setCellFactory(CheckBoxListCell.forListView(item -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener((obs, wasSelected, isNowSelected) -> {
                if (isNowSelected) {
                    current_user.getSpokenLanguages().add(item);
                } else {
                    current_user.getSpokenLanguages().remove(item);
                }
            });
            return observable;
        }));
        availProgramming.setCellFactory(CheckBoxListCell.forListView(item -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener((obs, wasSelected, isNowSelected) -> {
                if (isNowSelected) {
                    current_user.getProgrammingLanguages().add(item);
                } else {
                    current_user.getProgrammingLanguages().remove(item);
                }
            });
            return observable;
        }));
        loginTField.setText(user.getLogin());
        passwordTField.setText(user.getPassword());
        firstnameTField.setText(user.getFirstname());
        lastnameTField.setText(user.getLastname());
        birthdateTField.setText(user.getBirthdate());
        phoneTField.setText(user.getPhone());
        emailTField.setText(user.getEmail());
        addressTField.setText(user.getAddress());
        cityTField.setText(user.getCity());
        countryTField.setText(user.getCountry());
        experienceTField.setText(user.getExperienceProperty().get());
        stackTField.setText(user.getStackPointsProperty().get());
        hackerTField.setText(user.getHackerrankPointsProperty().get());
        imgView.setImage(user.getImage());
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
}
