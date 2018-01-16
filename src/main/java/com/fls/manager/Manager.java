package com.fls.manager;

import com.fls.Main;
import com.fls.chat.Chat;
import com.fls.chat.ChatContext;
import com.fls.entities.User;
import com.fls.forum.Forum;
import com.fls.manager.controller.ManagerController;
import com.fls.profiles.Profiles;
import com.fls.user_finder.UserFinder;
import com.fls.util.SoundEnum;
import com.fls.util.SoundPlayer;
import com.fls.wall.Wall;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
    private Chat chat;
    private ChatContext chatContext;
    private Profiles profiles;
    private UserFinder userFinder;
    private Forum forum;
    private Wall wall;
    private Scene scene;
    private AnchorPane rootLayout;
    private BorderPane borderPane;
    private Object actualCenterModule;
    private PanesHistory panesHistory;
    private Node actualCenterPane;

    public Manager(Main main, Long tokenId, Long userId, ChatContext chatContext) {
        this.main = main;
        this.tokenId = tokenId;
        this.userId = userId;
        this.chat = new Chat(chatContext);
        this.chatContext = chatContext;
        this.profiles = new Profiles(this);
        this.userFinder = new UserFinder(this);
        this.forum = new Forum();
        this.wall = new Wall(this);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("manager.fxml"));
        try {
            rootLayout = loader.load();
            scene = new Scene(rootLayout);
            controller = loader.getController();
            controller.setModel(this);
            borderPane = controller.borderPane;
            panesHistory = new PanesHistory(10);
            controller.setBindings(panesHistory.undoStackSizeProperty(), panesHistory.redoStackSizeProperty());
            loadWall();
            playLoginSound();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playLoginSound() {
        SoundPlayer.play(SoundEnum.LOGIN);
    }

    public void logout() {
        main.loadUserAuthentication();
    }

    public void newMessageNotification(long userId) {
        SoundPlayer.play(SoundEnum.NEW_MESSAGE);
    }

    public void loadChat(List<Long> userIds) {
        if (actualCenterModule != chat) {
            Node newPane = chat.load(userIds);
            panesHistory.addPane(newPane, chat);
            setCenterModule(newPane, chat);
        }
    }

    public void loadProfile(Long userId) {
        System.out.println("profil o id " + userId);
        if (actualCenterModule != profiles) {
            Node newPane = profiles.load(userId);
            panesHistory.addPane(newPane, profiles);
            setCenterModule(newPane, profiles);
        }
    }

    public void loadForum() {
        if (actualCenterModule != forum) {
            Node newPane = forum.load();
            panesHistory.addPane(newPane, forum);
            setCenterModule(newPane, forum);
        }
    }

    public void loadWall() {
        if (actualCenterModule != wall) {
            Node newPane = wall.load();
            panesHistory.addPane(newPane, wall);
            setCenterModule(newPane, wall);
        } else {
            wall.refreshPosts();
        }
    }

    public void loadUserFinder(String query) {
        if (actualCenterModule != userFinder) {
            Node newPane = userFinder.load(query);
            panesHistory.addPane(newPane, userFinder);
            setCenterModule(newPane, userFinder);
        } else {
            userFinder.searchForUsers(query);
        }
    }

    public Scene getScene() {
        return scene;
    }

    public void undo() {
        StackNode<Node, Object> node = panesHistory.undoPane();
        if (node != null) {
            setCenterModule(node.firstValue, node.secondValue);
        }
    }

    public void redo() {
        StackNode<Node, Object> node = panesHistory.redoPane();
        if (node != null) {
            setCenterModule(node.firstValue, node.secondValue);
        }
    }

    private void setCenterModule(Node pane, Object module) {
        borderPane.setCenter(pane);
        actualCenterPane = pane;
        actualCenterModule = module;
        SoundPlayer.play(SoundEnum.BUTTON_CLICK);
    }
}
