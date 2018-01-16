package com.fls.chat;

import com.fls.chat.event.ChatEventHandler;
import com.fls.chat.message.constructor.MessageConstructor;

import java.util.List;
import java.util.Map;

public class ChatContext {
    private final ChatUser chatUser;
    private final ChatServer chatServer;
    private final Map<Class, MessageConstructor> messageConstructors;
    private final Map<Class, List<ChatEventHandler>> eventHandlers;
    private final List<ChatRoom> openChatRooms;

    public ChatContext(ChatUser chatUser, ChatServer chatServer, Map<Class, MessageConstructor> messageConstructors, Map<Class, List<ChatEventHandler>> eventHandlers, List<ChatRoom> openChatRooms) {
        this.chatUser = chatUser;
        this.chatServer = chatServer;
        this.messageConstructors = messageConstructors;
        this.eventHandlers = eventHandlers;
        this.openChatRooms = openChatRooms;
    }

    public ChatUser getChatUser() {
        return chatUser;
    }

    public ChatServer getChatServer() {
        return chatServer;
    }

    public Map<Class, MessageConstructor> getMessageConstructors() {
        return messageConstructors;
    }

    public Map<Class, List<ChatEventHandler>> getEventHandlers() {
        return eventHandlers;
    }

    public List<ChatRoom> getOpenChatRooms() {
        return openChatRooms;
    }
}
