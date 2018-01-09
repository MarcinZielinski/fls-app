package com.fls.chat;

import com.fls.chat.event.ChatEvent;
import com.fls.chat.message.Message;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Set;

public class ChatRoom {

    private final String name;
    private final ChatSession chatSession;
    private final Set<ChatUser> roomMembers;
    private final List<Message> messages;

    public ChatRoom(String name, ChatSession chatSession, Set<ChatUser> roomMembers, List<Message> messages) {
        this.name = name;
        this.chatSession = chatSession;
        this.roomMembers = roomMembers;
        this.messages = messages;
    }

    void onEvent(ChatEvent event) {

    }

    void sendMessage(Message message) {
        chatSession.sendMessage(this, message);
    }

    public Pane load(ChatRoom chatRoom) {
        return new Pane();
    }

    public Set<ChatUser> getRoomMembers() {
        return roomMembers;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }
}
