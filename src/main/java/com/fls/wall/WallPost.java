package com.fls.wall;

import com.fls.entities.User;
import com.fls.wall.controller.WallPostController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by Marcin on 2017-12-12.
 */
public class WallPost {
    private Pane postView;
    private WallPostController postController;
    private User user;
    private String content;
    private Wall wall;

    public WallPost(User user, String content, Wall wall) {
        this.user = user;
        this.content = content;
        this.wall = wall;
    }

    public Pane load(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_wallpost.fxml"));
        try {
            postView = loader.load();
            postController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        postController.setModel(this);
        return postView;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public Wall getWall() {
        return wall;
    }
}
