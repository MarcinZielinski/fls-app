package com.fls.chat.message.constructor;

import com.fls.chat.message.MessageBlueprint;
import com.fls.chat.message.type.TextMessage;

public class TextMessageConstructor implements MessageConstructor<TextMessage> {

    @Override
    public TextMessage construct(MessageBlueprint<TextMessage> blueprint) {
        return new TextMessage(blueprint.getSender(), blueprint.getSendDate(), new String(blueprint.getContent()));
    }

    @Override
    public MessageBlueprint<TextMessage> deconstruct(TextMessage message) {
        return new MessageBlueprint<>(message, message.getText().getBytes());
    }

}
