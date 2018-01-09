package com.fls.chat.message;


import com.fls.chat.ChatUser;

import java.util.Date;

public class MessageBlueprint<M extends Message> {

    private final ChatUser sender;
    private final Date sendDate;
    private final Class<? extends Message> messageClass;
    private final byte[] content;

    public MessageBlueprint(ChatUser sender, Date sendDate, Class<M> messageClass, byte[] content) {
        this.sender = sender;
        this.sendDate = sendDate;
        this.messageClass = messageClass;
        this.content = content;
    }

    public MessageBlueprint(M message, byte[] content) {
        this.sender = message.getSender();
        this.sendDate = message.getSendDate();
        this.messageClass = message.getClass();
        this.content = content;
    }

    public ChatUser getSender() {
        return sender;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public Class<? extends Message> getMessageClass() {
        return messageClass;
    }

    public byte[] getContent() {
        return content;
    }
}
