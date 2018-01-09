package com.fls;

import com.fls.chat.ChatRoom;
import com.fls.entities.User;
import com.fls.wall.WallPost;

import java.util.List;

/**
 * Created by Marcin on 2017-12-12.
 */
public interface Server {
    static ChatRoom[] getUserChatRooms(Long userId) {
        return null;
    }

    static User getUser(Long userId) {
        return null;
    }

    static Long[] getUserFriends(Long userId) {
        return null;
    }

    static WallPost[] getWallPosts(Long userId) {
        return null;
    }

    static List<User> getUsers(String query) {
        return null;
    }
}
