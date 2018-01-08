package com.fls.forum;

import com.fls.forum.controller.SectionsPaneController;
import com.fls.forum.view.SectionsPane;
import com.fls.manager.Manager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ForumApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FLSocial");

        Parent root = FXMLLoader.load(getClass().getResource("pane_sections.fxml"));
        Scene scene = new Scene(root);
        stage = primaryStage;
        stage.setTitle("FLSocial");
        stage.setScene(scene);
        stage.show();

        //loadTopicsPane();

    }

    private void loadUserAuthentication() {
//=======
        //ApplicationController applicationController = new ApplicationController(primaryStage);
        //applicationController.loadPostsPane();
//>>>>>>> forum

    }

    public void loadManager(Long tokenId, Long userId) {
        Manager manager = new Manager(null, 1L, 1L);
        stage.setScene(manager.getScene());
    }

    private void loadTopicsPane() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pane_topics.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public static Long getUserId(){
        return 1L;
    }

}
