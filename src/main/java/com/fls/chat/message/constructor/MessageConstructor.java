package com.fls.chat.message.constructor;

import com.fls.chat.message.Message;
import com.fls.chat.message.MessageBlueprint;

public interface MessageConstructor<T extends Message> {

    T construct(MessageBlueprint<T> blueprint);

    MessageBlueprint<T> deconstruct(T message);

}
