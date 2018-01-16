package com.fls.chat;

import com.fls.chat.event.ChatEvent;
import com.fls.chat.event.ChatEventHandler;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Chat {

    private final ChatContext chatContext;
    private final Map<Class, List<ChatEventHandler>> eventHandlers;
    private final ChatSession chatSession;
    private final List<ChatRoom> openChatRooms;

    public Chat(ChatContext chatContext) {
        this.chatContext = chatContext;
        this.eventHandlers = chatContext.getEventHandlers();
        this.chatSession = chatContext.getChatServer().createChatSession(this, chatContext.getChatUser());
        this.openChatRooms = chatContext.getOpenChatRooms();
    }

    public ChatRoom openRoom(String name) {
        ChatRoom room = chatSession.openRoom(name);
        openChatRooms.add(room);
        return room;
    }

    public ChatRoom createRoom(String name, Set<ChatUser> roomMembers) {
        ChatRoom room = chatSession.createRoom(name, roomMembers);
        openChatRooms.add(room);
        return room;
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


    public Pane load(List<Long> userIds) {
        return null;
    }
}
