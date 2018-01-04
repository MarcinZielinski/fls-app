package com.fls.forum;

import com.fls.manager.Manager;
import com.fls.user_authentication.UserAuthentication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class ForumApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("FLSocial");
        stage.show();
        loadUserAuthentication();
    }
    private void loadUserAuthentication() {

        SectionsPane sectionsPane = new SectionsPane();
        stage.setScene(sectionsPane.getScene());
    }
    public void loadManager(Long tokenId, Long userId) {
        Manager manager = new Manager(null, 1L, 1L);
        stage.setScene(manager.getScene());
    }
}
