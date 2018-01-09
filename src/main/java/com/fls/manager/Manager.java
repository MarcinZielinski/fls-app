package com.fls.manager;

import com.fls.Main;
import com.fls.chat.ChatContext;
import com.fls.entities.User;
import com.fls.forum.Forum;
import com.fls.manager.controller.ManagerController;
import com.fls.profiles.Profiles;
import com.fls.user_finder.UserFinder;
import com.fls.wall.Wall;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

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
    private ChatContext chatContext;
    private Profiles profiles;
    private UserFinder userFinder;
    private Forum forum;
    private Wall wall;
    private Scene scene;
    private BorderPane rootLayout;

    public Manager(Main main, Long tokenId, Long userId, ChatContext chatContext) {
        this.main = main;
        this.tokenId = tokenId;
        this.userId = userId;
        this.chatContext = chatContext;
        this.profiles = new Profiles();
        this.userFinder = new UserFinder();
        this.forum = new Forum();
        this.wall = new Wall();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("manager.fxml"));
        try {
            rootLayout = loader.load();
            scene = new Scene(rootLayout);
            controller = loader.getController();
            controller.setModel(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        main.loadUserAuthentication();
    }

    public void newMessageNotification(long userId) {
    }

    public void loadChat() {
        main.loadChat(chatContext);
    }

    public void loadProfile(Long userIds) {
    }

    public void loadForum() {
    }

    public void loadWall() {
    }

    public void loadUserFinder(String query) {
        rootLayout.setCenter(userFinder.load(query));
    }

    public Scene getScene() {
        return scene;
    }
}
