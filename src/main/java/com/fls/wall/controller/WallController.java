package com.fls.wall.controller;

import com.fls.wall.Wall;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * Created by Marcin on 2017-12-12.
 */
public class WallController {
    private Wall model;
    @FXML
    public VBox vBox;

    @FXML
    void initialize(){

    }

    public void setModel(Wall model){
        this.model = model;
    }
    void updateModel(){

    }
}
