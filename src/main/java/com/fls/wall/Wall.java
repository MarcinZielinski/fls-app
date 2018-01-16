package com.fls.wall;

import com.fls.Server;
import com.fls.entities.User;
import com.fls.manager.Manager;
import com.fls.util.ImageConverter;
import com.fls.util.ThreadHelper;
import com.fls.wall.controller.WallController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    private StackPane stackPane;
    private WallController wController;
    private ThreadHelper actualTask;
    private List<WallPost> posts;
    private TitledPane postsPane;

    public Wall(Manager manager){
        this.manager = manager;
    }

    public Pane load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_wall.fxml"));
        try {
            rootPane = loader.load();
            wController = loader.getController();
            stackPane = wController.stackPane;
            postsPane = wController.postsPane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        wController.setModel(this);
        loadPosts();

        return rootPane;
    }

    private void loadPosts() {
        Platform.runLater(() -> postsPane.setExpanded(true));
        if(actualTask!=null) actualTask.cancel();
        actualTask = new ThreadHelper<>(stackPane, () -> Server.getWallPosts(manager.tokenId), this::loadPosts);
        actualTask.restart();
    }

    private void loadPosts(List<WallPost> wallPosts) {
        //posts = wallPosts;
        if(posts == null) {
            posts = new ArrayList<>();
            for (int i = 0; i < 5; ++i) {
                byte[] image = ImageConverter.convertToByteArray(new ImageView("com/fls/user_finder/thmb.jpg"));
                posts.add(0, new WallPost(new User(1L, 1L, "Andrzej", "Duda", image),
                        "BleBleBLe\ndasdaserdddddddddddddddddddddddddsad\ndfavdsedSDSAD", this, System.currentTimeMillis()-1000000000+i*2000));
            }
        }
        wController.loadPosts(posts);
    }

    public void refreshPosts() {
        loadPosts();
    }

    public Manager getManager() {
        return manager;
    }

    public WallController getwController(){
        return wController;
    }

    public void addPost(WallPost wp){
        posts.add(0, wp);
        loadPosts();
    }

    public void deletePost(WallPost wp){
        posts.remove(wp);
        loadPosts();
    }




}
