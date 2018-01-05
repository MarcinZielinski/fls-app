package com.fls.forum.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SectionsPane {

    private Pane layout;
    private Scene scene;

    public void load() {

        try {
            FXMLLoader loader = new FXMLLoader(SectionsPane.class.getResource("ua.fxml"));
            layout = loader.load();
            this.scene = new Scene(layout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}
