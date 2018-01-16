package com.fls.chat.message;

import com.fls.chat.ChatUser;

import java.util.Date;

public abstract class Message {

    private final ChatUser sender;
    private final Date sendDate;

    protected Message(ChatUser sender, Date sendDate) {
        this.sender = sender;
        this.sendDate = sendDate;
    }

    protected Message(MessageBlueprint blueprint) {
        this.sender = blueprint.getSender();
        this.sendDate = blueprint.getSendDate();
    }

    public ChatUser getSender() {
        return sender;
    }

    public Date getSendDate() {
        return sendDate;
    }
}
