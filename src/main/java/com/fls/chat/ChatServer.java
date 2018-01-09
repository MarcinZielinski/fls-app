package com.fls.chat;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class ChatServer {

    public List<String> getUserChatRooms(ChatUser chatUser) {
        return ImmutableList.of("AWS", "ABW", "AKW", "AMA");
    }

    public ChatSession createChatSession(Chat chat, ChatUser chatUser) {
        return null;
    }

    public long putResource(Object resource) {
        return -1;
    }

    public Object getResource(long resourceId) {
        return null;
    }

}
