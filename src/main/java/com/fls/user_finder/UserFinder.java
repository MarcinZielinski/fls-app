package com.fls.user_finder;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by Marcin on 2017-12-12.
 */
public class UserFinder {
    private Pane rootPane;
    private UFController ufController;
    private HBox hbox;

    public UserFinder() {

    }

    public Pane load(String query) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_userfinder.fxml"));
        try {
            rootPane = loader.load();
            ufController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        hbox = ufController.hBox;
        //hbox.getChildren().add(new UserFinderResult());

        return rootPane;
    }
}
