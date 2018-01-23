package com.fls.chat.controller;

import com.fls.chat.ChatRoom;
import com.fls.chat.message.text.TextMessage;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.LinkedList;
import java.util.List;

public class RoomController implements ChatController {

    private ChatRoom room;
    private List<String> messageContents = new LinkedList<>();

    @FXML
    private Pane roomPane;

    @FXML
    private Text roomName;

    @FXML
    private ListView<String> messagesView;


    public Pane loadPane() {

        roomName.setText(room.getName());

        messageContents.clear();
        room.getMessages().stream()
                .map(m -> ((TextMessage) m).getText())
                .forEach(messageContents::add);

        messagesView.setItems(FXCollections.observableList(messageContents));

        return roomPane;
    }

    public void setRoom(ChatRoom room) {
        this.room = room;
    }
}
