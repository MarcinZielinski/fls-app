package com.fls.forum;

import com.fls.forum.controller.ApplicationController;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Marcin on 2017-12-12.
 */
public class Forum {
    public void load(Stage primaryStage) {
        new ApplicationController(primaryStage).loadSectionsPane();
    }
}