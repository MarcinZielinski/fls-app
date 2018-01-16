package com.fls.chat.event;

import com.fls.chat.ChatRoom;
import com.fls.chat.ChatUser;

public class UserLeftRoomEvent extends ChatEvent {

    private final ChatUser user;

    protected UserLeftRoomEvent(ChatRoom chatRoom, ChatUser user) {
        super(chatRoom);
        this.user = user;
    }

    public ChatUser getUser() {
        return user;
    }
}
