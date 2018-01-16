package com.fls.chat.event;

import com.fls.chat.ChatRoom;

public abstract class ChatEvent {

    private final ChatRoom chatRoom;

    protected ChatEvent(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }
}
