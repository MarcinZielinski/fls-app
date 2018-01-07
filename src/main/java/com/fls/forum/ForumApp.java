package com.fls.forum;

import com.fls.forum.controller.ApplicationController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ForumApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FLSocial");

        ApplicationController applicationController = new ApplicationController(primaryStage);
        applicationController.loadPostsPane();

    }

    public static Long getUserId(){
        return 1L;
    }

}
