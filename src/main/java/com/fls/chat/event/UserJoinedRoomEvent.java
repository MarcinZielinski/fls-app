package com.fls.chat.event;

import com.fls.chat.ChatRoom;
import com.fls.chat.ChatUser;

public class UserJoinedRoomEvent extends ChatEvent {

    private final ChatUser user;

    protected UserJoinedRoomEvent(ChatRoom chatRoom, ChatUser user) {
        super(chatRoom);
        this.user = user;
    }

    public ChatUser getUser() {
        return user;
    }
}
