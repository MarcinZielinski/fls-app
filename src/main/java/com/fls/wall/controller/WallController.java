package com.fls.wall.controller;

import com.fls.wall.Wall;
import com.fls.wall.WallPost;
import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javax.annotation.Generated;

/**
 * Created by Marcin on 2017-12-12.
 */
public class WallController {
    @FXML
    public StackPane stackPane;
    public TitledPane postsPane;

    private Wall model;

    @FXML
    private VBox posts;

    @FXML
    void initialize(){
        posts.layoutYProperty().addListener(( x ) -> posts.setLayoutY(0));
    }

    public void loadPosts(WallPost[] posts){
        this.posts.getChildren().clear();
        if(posts != null) {
            for (WallPost wallPost : posts) {
                this.posts.getChildren().add(wallPost.load());
            }
        }
    }

    public void setModel(Wall model){
        this.model = model;
    }
    void updateModel(){

    }

    public VBox getPostsVBox(){
        return posts;
    }

}
