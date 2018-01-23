package com.fls.chat.controller;

import com.fls.chat.ChatContext;
import com.fls.chat.ChatPresenter;
import com.fls.chat.ChatRoom;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LobbyController implements ChatController {

    //todo change
    private final Map<String, ChatRoom> openRooms = new HashMap<>();

    private ChatContext ctx;
    private ChatPresenter presenter;

    @FXML
    private Pane lobbyPane;

    @FXML
    private ListView<String> openRoomsView;

    @FXML
    public void onRoomClicked(MouseEvent e) {
        String selectedRoomName = openRoomsView.getSelectionModel().getSelectedItem();
        presenter.openRoomWindow(openRooms.get(selectedRoomName));
    }

    public Pane loadPane() {
        openRooms.clear();

        ctx.getOpenRooms().forEach(r -> openRooms.put(r.getName(), r));

        List<String> roomNames = ctx.getOpenRooms().stream().map(ChatRoom::getName).collect(Collectors.toList());
        openRoomsView.setItems(FXCollections.observableList(roomNames));
        return lobbyPane;
    }

    public void setContext(ChatContext ctx) {
        this.ctx = ctx;
    }

    public void setPresenter(ChatPresenter presenter) {
        this.presenter = presenter;
    }
}
