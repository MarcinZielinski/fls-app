package com.fls.chat.message.type;

import com.fls.chat.message.Message;
import com.fls.chat.ChatUser;

import java.util.Date;

public class TextMessage extends Message {

    private final String text;



    public TextMessage(ChatUser sender, Date sendDate, String text) {
        super(sender, sendDate);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
