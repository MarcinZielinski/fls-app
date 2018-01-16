package com.fls.chat;

import com.fls.chat.event.ChatEvent;
import com.fls.chat.message.Message;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Set;

public class ChatRoom {

    private final ChatContext ctx;
    private final String name;
    private final Set<ChatUser> members;
    private final List<Message> messages;

    public ChatRoom(ChatContext ctx, String name, Set<ChatUser> members, List<Message> messages) {
        this.ctx = ctx;
        this.name = name;
        this.members = members;
        this.messages = messages;
    }

    void onEvent(ChatEvent event) {

    }

    void sendMessage(Message message) {
        ctx.getSession().sendMessage(this, message);
    }

    public Pane load(ChatRoom chatRoom) {
        return new Pane();
    }

    public Set<ChatUser> getMembers() {
        return members;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }
}
