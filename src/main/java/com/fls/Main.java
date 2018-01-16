package com.fls;

import com.fls.chat.ChatContext;
import com.fls.chat.ChatServer;
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
    public void start(Stage primaryStage) throws Exception {
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
        // todo @Chat context
        Manager manager = new Manager(this, tokenId, userId,
                new ChatContext(null, new ChatServer(), null, null, null));
        stage.setScene(SoundPlayer.addSoundToScene(manager.getScene()));
    }
}
