package com.fls.chat;

import com.fls.chat.event.ChatEvent;
import com.fls.chat.event.ChatEventHandler;
import com.fls.chat.message.constructor.TextMessageConstructor;
import com.fls.chat.message.type.TextMessage;
import com.fls.manager.Manager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Chat {

    private final ChatContext ctx;

    public Chat(Manager manager) {

        ChatUser johnny = new ChatUser("Johnny");
        ChatUser george = new ChatUser("George");

        this.ctx = new ChatContext(
                johnny,
                new ChatSession(),
                ImmutableMap.of(TextMessage.class, new TextMessageConstructor()),
                ImmutableMap.of(),
                new ArrayList<>(),
                new ChatPresenter());

        ctx.getOpenRooms().add(new ChatRoom(ctx, "CircleGeork",
                ImmutableSet.of(johnny, george),
                ImmutableList.of(new TextMessage(johnny, new Date(), "Hullo!"))));

        ctx.getPresenter().loadLobbyPane(ctx);

    }

    public ChatRoom openRoom(String name) {
        ChatRoom room = getContext().getSession().openRoom(name);
        getContext().getOpenRooms().add(room);
        return room;
    }

    public ChatRoom createRoom(String name, Set<ChatUser> roomMembers) {
        ChatRoom room = getContext().getSession().createRoom(name, roomMembers);
        getContext().getOpenRooms().add(room);
        return room;
    }

    public void onEvent(ChatEvent event) {
        if (getContext().getEventHandlers().containsKey(event.getClass())) {
            getContext().getEventHandlers().get(event.getClass())
                    .forEach(h -> h.handle(event));
        }
    }

    public <E extends ChatEvent> void subscribe(Class<E> eventClass, ChatEventHandler<E> handler) {
        List<ChatEventHandler> handlers =
                getContext().getEventHandlers().getOrDefault(eventClass, new ArrayList<>());
        handlers.add(handler);
        getContext().getEventHandlers().put(eventClass, handlers);
    }

    public Pane load(List<Long> userIds) {
        return getContext().getPresenter().getCurrentPane();
    }

    public ChatContext getContext() {
        return ctx;
    }

}
