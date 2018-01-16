package com.fls.chat.event;

public interface ChatEventHandler<E extends ChatEvent> {

    void handle(E event);

}
