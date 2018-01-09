package com.fls.chat;

import com.fls.chat.event.ChatEvent;
import com.fls.chat.message.Message;

import java.util.List;
import java.util.Set;

public class ChatRoom {

    private final ChatSession chatSession;
    private final Set<ChatUser> roomMembers;
    private final List<Message> messages;

    public ChatRoom(ChatSession chatSession, Set<ChatUser> roomMembers, List<Message> messages) {
        this.chatSession = chatSession;
        this.roomMembers = roomMembers;
        this.messages = messages;
    }

    void onEvent(ChatEvent event) {

    }

    void sendMessage(Message message) {
        chatSession.sendMessage(this, message);
    }


    public Set<ChatUser> getRoomMembers() {
        return roomMembers;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
