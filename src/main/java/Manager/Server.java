package Manager;

/**
 * Created by Marcin on 2017-12-12.
 */
public interface Server {
    static ChatSession[] getAllChatSessions(Long userId) {return null;}
    static User getUser(Long userId) {return null;}
    static Long[] getUserFriends(Long userId) {return null;}
    static WallPost[] getWallPosts(Long userId) {return null;}
}
