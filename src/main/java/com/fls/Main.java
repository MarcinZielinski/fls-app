package com.fls;

import com.fls.manager.Manager;
import com.fls.user_authentication.UserAuthentication;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Marcin on 2017-12-12.
 */
public class Main extends Application {
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
    public void loadUserAuthentication() {
        UserAuthentication authentication = new UserAuthentication(this);
        stage.setScene(authentication.getScene());
    }
    public void loadManager(Long tokenId, Long userId) {
        Manager manager = new Manager(this, tokenId, userId);
        stage.setScene(manager.getScene());
    }
}
