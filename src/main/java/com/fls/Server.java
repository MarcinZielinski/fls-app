package com.fls;

import com.fls.chat.ChatSession;
import com.fls.entities.Category;
import com.fls.entities.User;
import com.fls.profiles.model.IUser;
import com.fls.wall.WallPost;

import java.util.List;

/**
 * Created by Marcin on 2017-12-12.
 */
public class Server {

    public final static String SERVER_ADDRESS = "http://localhost:8080";

    private final static String GET_CATEGORY_BY_ID_ENDPOINT = "getCategory?categoryId={id}";
    private final static String GET_USER_BY_ID_ENDPOINT = "getProfile?profileId={id}";

    public static ChatSession[] getAllChatSessions(Long userId) {return null;}
    public static User getUser(Long userId) {
        return new RequestCreator().getForObject(GET_USER_BY_ID_ENDPOINT, User.class, userId);
    }
    public static Long[] getUserFriends(Long userId) { return null; }
    public static List<WallPost> getWallPosts(Long userId) { return null; }
    public static List<User> getUsers(User user) { return null; }
    public static Long createPost(WallPost wp) { return null; }
    public static Category getCategory(Long categoryId) {
        return new RequestCreator().getForObject(GET_CATEGORY_BY_ID_ENDPOINT, Category.class, categoryId);
    }
//    public static User createUser(IUser user){
//
//    }
}
