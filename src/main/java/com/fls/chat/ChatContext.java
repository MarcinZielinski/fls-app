package com.fls.chat;

import com.fls.chat.event.ChatEventHandler;
import com.fls.chat.message.constructor.MessageConstructor;

import java.util.List;
import java.util.Map;

public class ChatContext {

    private final ChatUser user;
    private final ChatSession session;
    private final Map<Class, MessageConstructor> messageConstructors;
    private final Map<Class, List<ChatEventHandler>> eventHandlers;
    private final List<ChatRoom> openRooms;
    private final ChatPresenter presenter;

    public ChatContext(ChatUser user, ChatSession session, Map<Class, MessageConstructor> messageConstructors, Map<Class, List<ChatEventHandler>> eventHandlers, List<ChatRoom> openRooms, ChatPresenter presenter) {
        this.user = user;
        this.session = session;
        this.messageConstructors = messageConstructors;
        this.eventHandlers = eventHandlers;
        this.openRooms = openRooms;
        this.presenter = presenter;
    }

    public ChatUser getUser() {
        return user;
    }

    public ChatSession getSession() {
        return session;
    }

    public Map<Class, MessageConstructor> getMessageConstructors() {
        return messageConstructors;
    }

    public Map<Class, List<ChatEventHandler>> getEventHandlers() {
        return eventHandlers;
    }

    public List<ChatRoom> getOpenRooms() {
        return openRooms;
    }

    public ChatPresenter getPresenter() {
        return presenter;
    }
}
