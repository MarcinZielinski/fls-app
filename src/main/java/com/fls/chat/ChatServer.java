package com.fls.chat;

public interface ChatServer {
    ChatSession createChatSession(ChatClient chatClient, ChatUser chatUser);
}
