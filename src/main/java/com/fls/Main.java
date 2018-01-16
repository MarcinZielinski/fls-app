package com.fls;

import com.fls.manager.Manager;
import com.fls.user_authentication.UserAuthentication;
import com.fls.util.SoundPlayer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Marcin on 2017-12-12.
 */
public class Main extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("FLSocial");
        stage.setMinWidth(300);
        stage.show();

        loadUserAuthentication();
    }

    public void loadUserAuthentication() {
        UserAuthentication authentication = new UserAuthentication(this);
        stage.setScene(SoundPlayer.addSoundToScene(authentication.getScene()));
    }

    public void loadManager(Long tokenId, Long userId) {
        Manager manager = new Manager(this, tokenId, userId);
        stage.setScene(SoundPlayer.addSoundToScene(manager.getScene()));
    }
}
