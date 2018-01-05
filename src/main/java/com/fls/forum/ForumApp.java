package com.fls.forum;

import com.fls.forum.loader.PostsLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ForumApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception {


        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FLSocial");

        Pane postsPane = new PostsLoader().load();

        Scene scene = new Scene(postsPane);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

}
