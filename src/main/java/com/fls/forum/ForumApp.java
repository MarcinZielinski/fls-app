package com.fls.forum;

import com.fls.forum.controller.ApplicationController;
import com.fls.forum.controller.SectionsPaneController;
import com.fls.forum.controller.dataGenerator;
import com.fls.forum.model.generator.DataGenerator;
import com.fls.forum.view.SectionsPane;
import com.fls.manager.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ForumApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        dataGenerator.init();
        ApplicationController applicationController = new ApplicationController(primaryStage);
        applicationController.loadSectionsPane();

    }


    public static Long getUserId(){
        return 2L;
    }


}
