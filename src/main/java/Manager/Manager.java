package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

/**
 * Created by Marcin on 2017-12-12.
 */
public class Manager {
    public final long tokenId;
    public final long userId;
    private final Main main;
    private ManagerController controller;
    private List<User> friendsOnline;
    private Chat chat;
    private Profiles profiles;
    private UserSearcher userSearcher;
    private Forum forum;
    private Wall wall;
    private Scene scene;

    public Manager(Main main, Long tokenId, Long userId) {
        this.main = main;
        this.tokenId = tokenId;
        this.userId = userId;
        this.chat = new Chat();
        this.profiles = new Profiles();
        this.userSearcher = new UserSearcher();
        this.forum = new Forum();
        this.wall = new Wall();

        FXMLLoader loader = new FXMLLoader(Manager.class.getResource("manager.fxml"));
        loader.setLocation(Manager.class.getResource("../manager.fxml"));
        try {
            Pane rootLayout = loader.load();
            scene = new Scene(rootLayout);
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        main.loadUserAuthentication();
    }

    public void newMessageNotification(long userId) {}

    public void loadChat(List<Long> userIds) {chat.load(userIds);}
    public void loadProfile(Long userIds) {}
    public void loadForum() {}
    public void loadWall() {}
    public void loadUserSearcher() {}

    public Scene getScene() {
        return scene;
    }
}
