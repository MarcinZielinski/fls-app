package com.fls.wall.controller;

import com.fls.wall.Wall;
import com.fls.wall.WallPost;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import javax.annotation.Generated;

/**
 * Created by Marcin on 2017-12-12.
 */
public class WallController {
    private Wall model;

    @FXML
    private VBox posts;

    @FXML
    void initialize(){
        posts.layoutYProperty().addListener(( x ) -> posts.setLayoutY(0));
    }

    public void loadPosts(WallPost[] posts){
        for(WallPost wallPost : posts){
            this.posts.getChildren().add(wallPost.load());
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
