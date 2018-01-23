package com.fls.chat.message;

public interface MessageConstructor<T extends Message> {

    T construct(MessageBlueprint<T> blueprint);

    MessageBlueprint<T> deconstruct(T message);

}
