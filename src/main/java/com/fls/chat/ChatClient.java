package com.fls.chat;

import com.fls.chat.event.ChatEvent;
import com.fls.chat.event.ChatEventHandler;
import com.fls.chat.message.constructor.MessageConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatClient {

    private final Map<Class, List<ChatEventHandler>> eventHandlers;
    private final ChatSession chatSession;

    public ChatClient(ChatUser chatUser,
                      ChatServer chatServer,
                      Map<Class, MessageConstructor> messageConstructors,
                      Map<Class, List<ChatEventHandler>> eventHandlers
    ) {
        this.eventHandlers = eventHandlers;
        this.chatSession = chatServer.createChatSession(this, chatUser);
    }

    public ChatRoom openRoom(Set<ChatUser> roomMembers) {
        return null;
    }

    public void onEvent(ChatEvent event) {
        if (eventHandlers.containsKey(event.getClass())) {
            eventHandlers.get(event.getClass())
                    .forEach(h -> h.handle(event));
        }
    }

    public <E extends ChatEvent> void subscribe(Class<E> eventClass, ChatEventHandler<E> handler) {
        List<ChatEventHandler> handlers = eventHandlers.getOrDefault(eventClass, new ArrayList<>());
        handlers.add(handler);
        eventHandlers.put(eventClass, handlers);
    }

}
