package com.fls.chat;

import com.fls.chat.message.Message;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Set;

public class ChatSession {

    public List<String> getUserChatRooms(ChatUser chatUser) {
        return ImmutableList.of("AWS", "ABW", "AKW", "AMA");
    }

    public long putResource(Object resource) {
        return -1;
    }

    public Object getResource(long resourceId) {
        return null;
    }

    ChatRoom createRoom(String name, Set<ChatUser> roomMembers) {
        return null;
    }

    ChatRoom openRoom(String name) {
        return null;
    }

    void sendMessage(ChatRoom room, Message message) {

    }

    List<Message> getMessages(ChatRoom room) {
        return null;
    }

}
