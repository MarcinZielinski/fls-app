package com.fls.chat;

import com.fls.chat.message.Message;

import java.util.List;

public interface ChatSession {

    void joinRoom(ChatRoom room);

    void sendMessage(ChatRoom room, Message message);

    List<Message> getMessages(ChatRoom room);

    long putResource(Object resource);

    Object getResource(long resourceId);

}
