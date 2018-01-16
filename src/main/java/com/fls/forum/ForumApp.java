package com.fls.forum;

import com.fls.forum.model.ServerObjectController;
import javafx.application.Application;
import javafx.scene.Scene;
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
