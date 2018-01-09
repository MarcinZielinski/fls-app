package com.fls.chat.event;

import com.fls.chat.message.Message;
import com.fls.chat.ChatRoom;

public class NewMessageEvent extends ChatEvent {

    private final Message message;

    protected NewMessageEvent(ChatRoom chatRoom, Message message) {
        super(chatRoom);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
