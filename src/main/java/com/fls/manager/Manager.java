package com.fls.manager;

import com.fls.Main;
import com.fls.chat.Chat;
import com.fls.entities.User;
import com.fls.forum.Forum;
import com.fls.profiles.Profiles;
import com.fls.user_finder.UserFinder;
import com.fls.manager.controller.ManagerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import com.fls.wall.Wall;

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
    private UserFinder userFinder;
    private Forum forum;
    private Wall wall;
    private Scene scene;
    private AnchorPane rootLayout;
    private BorderPane borderPane;

    public Manager(Main main, Long tokenId, Long userId) {
        this.main = main;
        this.tokenId = tokenId;
        this.userId = userId;
        this.chat = new Chat(this);
        this.profiles = new Profiles(this);
        this.userFinder = new UserFinder(this);
        this.forum = new Forum(this);
        this.wall = new Wall(this);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("manager.fxml"));
        try {
            rootLayout = loader.load();
            borderPane = (BorderPane)rootLayout.getChildren().get(0);
            scene = new Scene(rootLayout);
            controller = loader.getController();
            controller.setModel(this);
            loadWall();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        main.loadUserAuthentication();
    }

    public void newMessageNotification(long userId) {}

    public void loadChat(List<Long> userIds) {chat.load(userIds);}
    public void loadProfile(Long userId) {
        System.out.println("profil o id " + userId);
    }
    public void loadForum() {}
    public void loadWall() {
        borderPane.setCenter(wall.load());
    }
    public void loadUserFinder(String query) {
        borderPane.setCenter(userFinder.load(query));
    }

    public Scene getScene() {
        return scene;
    }
}
