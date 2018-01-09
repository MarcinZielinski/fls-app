package com.fls.chat;

import com.fls.chat.message.Message;

import java.util.List;
import java.util.Set;

public interface ChatSession {

    ChatRoom createRoom(String name, Set<ChatUser> roomMembers);

    ChatRoom openRoom(String name);

    void sendMessage(ChatRoom room, Message message);

    List<Message> getMessages(ChatRoom room);

}
