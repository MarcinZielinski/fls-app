package com.fls.wall;

import com.fls.wall.controller.WallController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by Marcin on 2017-12-12.
 */
public class Wall {
    private Pane rootPane;
    private WallController wController;
    private VBox vBox;
    public Pane load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_wall.fxml"));
        try {
            rootPane = loader.load();
            wController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        wController.setModel(this);
        vBox = wController.vBox;
        return rootPane;
    }
}
