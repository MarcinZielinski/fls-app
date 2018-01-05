package com.fls.forum.loader;

import com.fls.forum.ForumApp;
import com.fls.forum.controller.PostsController;
import com.fls.forum.model.generator.DataGenerator;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class PostsLoader {

    public PostsLoader(){
    }


    public Pane load() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ForumApp.class.getResource("pane_posts.fxml"));


        Pane root;
        root = loader.load();

        PostsController postsController = loader.getController();
//        controller.setAppController(this);
        postsController.setData(1, 1, DataGenerator.generatePosts());

        return root;

    }

}
