package com.fls.forum.loader;

import com.fls.forum.controller.PostsController;
import com.fls.forum.model.generator.DataGenerator;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class PostsLoader {

    private URL location;

    public PostsLoader(URL location){
        this.location = location;
    }


    public Pane load() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        Pane root;
        root = loader.load();

        PostsController postsController = loader.getController();
//        controller.setAppController(this);
        postsController.setData(1, 1, DataGenerator.generatePosts());

        return root;

    }

}
