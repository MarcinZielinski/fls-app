package com.fls.chat;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class ChatLobbyController {

    private final Chat chat;

    @FXML
    private final ListView<String> chatRoomListView;

    public ChatLobbyController(ChatContext chatContext) {
        this.chat = new Chat(chatContext);

        List<String> chatRooms = chatContext.getChatServer().getUserChatRooms(chatContext.getChatUser());

        this.chatRoomListView = new ListView<>(FXCollections.observableList(chatRooms));
    }

    public Scene getScene() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chat_lobby.fxml"));
        try {
            Pane lobbyPane = loader.load();
            return new Scene(lobbyPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
