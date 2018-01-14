package com.fls.forum;

import com.fls.forum.controller.ForumController;
import com.fls.forum.controller.dataGenerator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ForumApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new Forum().load()));
        primaryStage.show();
    }

}
