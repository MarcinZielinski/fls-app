package com.fls.chat;

import com.fls.chat.controller.ChatController;
import com.fls.chat.controller.LobbyController;
import com.fls.chat.controller.RoomController;
import com.fls.manager.Manager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ChatPresenter {

    private final ChatContext ctx;
    private final Manager manager;

    public ChatPresenter(ChatContext ctx, Manager manager) {
        this.ctx = ctx;
        this.manager = manager;
    }

    private ChatController loadController(String resource) {

        FXMLLoader loader = new FXMLLoader(ChatPresenter.class.getResource(resource));

        try {
            //todo check without load
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loader.getController();
    }

    public Pane getLobbyPane() {

        LobbyController controller = (LobbyController) loadController("pane_lobby.fxml");
        controller.setContext(ctx);
        controller.setPresenter(this);

        return controller.loadPane();
    }

    public Window openRoomWindow(ChatRoom room) {

        RoomController controller = (RoomController) loadController("pane_room.fxml");
        controller.setRoom(room);

        Scene scene = new Scene(controller.loadPane());
        Stage roomStage = new Stage();

        roomStage.setTitle(room.getName());
//        dialogStage.initModality(Modality.NONE);
        roomStage.initOwner(manager.getScene().getWindow());
        roomStage.setScene(scene);
        roomStage.show();

        return roomStage;
    }

}
