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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FLSocial");
        primaryStage.setScene(new Scene(new PostsLoader().load()));
        primaryStage.show();
    }

    public static Long getUserId(){
        return 1L;
    }

}
