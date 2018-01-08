package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Post;
import com.fls.forum.model.generator.DataGenerator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationController {

    private Stage primaryStage;

    public ApplicationController(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("FLSocial");

    }


    public void loadPostsPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ForumApp.class.getResource("pane_posts.fxml"));


        Pane root;
        root = loader.load();

        PostsController postsController = loader.getController();
        postsController.setApplicationController(this);
        postsController.setData(1L, 1L, DataGenerator.generatePosts());

        primaryStage.setScene(new Scene(root));

        primaryStage.show();

    }

    public void loadEditPane(Post post) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ForumApp.class.getResource("pane_edit.fxml"));

        try {
            Pane root = loader.load();
            EditorController editorController = loader.getController();

            Stage editStage = new Stage();
            editorController.setData(post, editStage);

            editStage.setScene(new Scene(root));
            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadSectionsPane(){
        primaryStage.setTitle("FLSocial");

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ForumApp.class.getResource("pane_sections.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            SectionsPaneController sectionsPaneController = loader.getController();
            sectionsPaneController.setApplicationController(this);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //loadTopicsPane();
    }

    public void loadTopicsPane(TopicsPaneController topicsPaneController){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ForumApp.class.getResource("pane_topics.fxml"));
        loader.setController(topicsPaneController);
        try {
            Parent sectionsParent = loader.load();
            Scene scene = new Scene(sectionsParent);

//        Stage window = (Stage)(source.getScene().getWindow());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}