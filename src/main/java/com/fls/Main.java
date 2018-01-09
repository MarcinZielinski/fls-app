package com.fls;

import com.fls.chat.ChatContext;
import com.fls.chat.ChatServer;
import com.fls.chat.ChatUser;
import com.fls.chat.ChatLobbyController;
import com.fls.chat.message.constructor.TextMessageConstructor;
import com.fls.chat.message.type.TextMessage;
import com.fls.manager.Manager;
import com.fls.user_authentication.UserAuthentication;
import com.google.common.collect.ImmutableMap;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

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
        stage.show();
        loadUserAuthentication();
    }

    public void loadUserAuthentication() {
        UserAuthentication authentication = new UserAuthentication(this);
        stage.setScene(authentication.getScene());
    }

    public void loadManager(Long tokenId, Long userId) {
        Manager manager = new Manager(this, tokenId, userId, new ChatContext(
                new ChatUser("Aleksander Siódmy"),
                new ChatServer(),
                ImmutableMap.of(TextMessage.class, new TextMessageConstructor()),
                new HashMap<>(),
                new ArrayList<>()));
        stage.setScene(manager.getScene());
    }

    public void loadChat(ChatContext chatContext) {
        stage.setScene(new ChatLobbyController(chatContext).getScene());
    }

}
