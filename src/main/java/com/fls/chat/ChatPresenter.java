package com.fls.chat;

import com.fls.chat.controller.ChatController;
import com.fls.chat.controller.LobbyController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ChatPresenter {

    private final FXMLLoader loader;

    private Pane currentPane;
    private ChatController currentController;

    public ChatPresenter() {
        this.loader = new FXMLLoader();
    }

    private ChatController getController(String resource) {
        loader.setLocation(ChatPresenter.class.getResource(resource));

        try {
            //todo check without load
            loader.load();
            currentController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return currentController;
    }

    public Pane loadLobbyPane(ChatContext ctx) {

        LobbyController controller = (LobbyController) getController("pane_lobby.fxml");
        controller.setContext(ctx);

        currentPane = controller.loadPane();

        return currentPane;
    }

    public Pane loadRoomPane(ChatRoom room) {
        //todo
        return getController("pane_room.fxml").loadPane();
    }

    public Pane getCurrentPane() {
        return currentPane;
    }

}
