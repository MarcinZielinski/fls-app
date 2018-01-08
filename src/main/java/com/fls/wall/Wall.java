package com.fls.wall;

import com.fls.Server;
import com.fls.entities.User;
import com.fls.manager.Manager;
import com.fls.util.ImageConverter;
import com.fls.wall.controller.WallController;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2017-12-12.
 */
public class Wall {
    private Manager manager;
    private Pane rootPane;
    private WallController wController;
    private WallPost[] posts;

    public Wall(Manager manager){
        this.manager = manager;
    }

    public Pane load() {
        if(rootPane == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_wall.fxml"));
            try {
                rootPane = loader.load();
                wController = loader.getController();
            } catch (IOException e) {
                e.printStackTrace();
            }
            wController.setModel(this);
        }
        posts = Server.getWallPosts(manager.userId);
        posts = new WallPost[5];
        for(int i =0; i < posts.length; ++i){
            byte[] image = ImageConverter.convertToByteArray(new ImageView("com/fls/user_finder/thmb.jpg"));
            posts[i] = new WallPost(new User(1L, 1L, "Andrzej", "Duda", image),
                    "BleBleBLe\ndasdaserdddddddddddddddddddddddddsad\ndfavdsedSDSAD");
        }
        wController.loadPosts(posts);

        return rootPane;
    }

    public void refreshPosts() {

    }
}
