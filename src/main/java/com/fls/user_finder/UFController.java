package com.fls.user_finder;

import com.fls.entities.User;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.*;

/**
 * Created by Marcin on 2017-12-18.
 */
public class UFController {
    @FXML
    public VBox searchResultsVBox;
    public TitledPane resultsPane;
    public Button addSpokenLanguageButton;
    public GridPane spokenLaguagesGridPane;
    public Slider experienceSlider;
    public Label experienceLabel;
    public TextField programmingLangsTextField;
    public TextField nameTextField;
    public TextField pointsFls;
    public TextField pointsStack;
    public TextField pointsHackerrank;
    public StackPane stackPane;

    private List<String> spokenLanguagesList;
    private VBox languagesVbox;
    private UserFinder model;

    @FXML
    private void initialize() {
        spokenLanguagesList = new ArrayList<>();
        languagesVbox = new VBox();
        spokenLaguagesGridPane.add(languagesVbox,0,4);
        experienceSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            experienceSlider.setValue((int) Math.round(newValue.doubleValue()));
            experienceLabel.setText(String.format("Years (minimum): %d", (int)experienceSlider.getValue()));
        });
        pointsFls.addEventFilter(KeyEvent.KEY_TYPED, e -> { if(!Character.isDigit(e.getCharacter().charAt(0))) e.consume(); });
        pointsStack.addEventFilter(KeyEvent.KEY_TYPED, e -> { if(!Character.isDigit(e.getCharacter().charAt(0))) e.consume(); });
        pointsHackerrank.addEventFilter(KeyEvent.KEY_TYPED, e -> { if(!Character.isDigit(e.getCharacter().charAt(0))) e.consume(); });
    }

    public void addSpokenLanguage(ActionEvent actionEvent) {
        HBox newHBox = new HBox();
        ObservableList<String> languages = FXCollections.observableArrayList("Spanish", "Czech", "Russian", "Danish", "Dutch");
        ComboBox<String> comboBox = new ComboBox<>(languages);
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            spokenLanguagesList.add(newValue);
            spokenLanguagesList.remove(oldValue);
        });
        Button minusButton = new Button("-");
        minusButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            spokenLanguagesList.remove((String)((ComboBox)newHBox.getChildren().stream().filter(ComboBox.class::isInstance).findFirst().get()).getValue());
            languagesVbox.getChildren().removeAll(newHBox);
        });
        newHBox.getChildren().addAll(minusButton, comboBox);
        languagesVbox.getChildren().add(newHBox);
    }

    public void searchForUser(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String[] nameSplit = name.split(" ");
        String firstName = nameSplit[0];
        String lastName = name.length() > firstName.length() ? name.substring(firstName.length()+1) : "";
        Set<String> spokenLanguages = new HashSet<>(spokenLanguagesList);
        Set<String> programmingLanguages = new HashSet<>(Arrays.asList(programmingLangsTextField.getText().split("[,;]")));
        Integer experience = (int)Math.round(experienceSlider.getValue());

        System.out.println(
                String.format("Name: %s\n" +
                                "spokenLanguages: %s\n" +
                                "programmingLanguages: %s\n" +
                                "experience %d\n" +
                                "points: FLS - %s, Stack - %s, Hackerrank = %s",
                        name, spokenLanguages.toString(), programmingLanguages.toString(), experience, pointsFls.getText(), pointsStack.getText(), pointsHackerrank.getText()
                )
        );
        model.searchForUsers(
                new User(
                        firstName,
                        lastName,
                        spokenLanguages,
                        programmingLanguages,
                        experience,
                        Integer.parseInt(pointsFls.getText()),
                        Integer.parseInt(pointsStack.getText()),
                        Integer.parseInt(pointsHackerrank.getText())
                )
        );
    }

    public void spokenLangChecked(ActionEvent actionEvent) {
        CheckBox checkBox = (CheckBox) actionEvent.getSource();
        if (checkBox.isSelected()) {
            spokenLanguagesList.add(checkBox.getText());
        } else {
            spokenLanguagesList.remove(checkBox.getText());
        }
    }

    public void setModel(UserFinder model) {
        this.model = model;
    }
}
