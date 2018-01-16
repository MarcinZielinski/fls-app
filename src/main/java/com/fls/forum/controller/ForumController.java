package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.ServerController;
import com.fls.forum.model.localModel.Post;
import com.fls.forum.model.localModel.Section;
import com.fls.forum.model.localModel.Topic;
import com.fls.manager.Manager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ForumController {

    private Pane primaryPane = new AnchorPane();

    private Manager manager;
    private ServerController serverController = new ServerController();

    public ForumController() {
        dataGenerator.init();
    }


    public void loadPostsPane(Topic topic){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ForumApp.class.getResource("pane_posts.fxml"));

        try {
            Pane root = loader.load();

            topic.loadPosts(serverController);
            PostsController postsController = loader.getController();
            postsController.setForumController(this);
            postsController.setData(getUserId(), topic);

            primaryPane.getChildren().clear();
            primaryPane.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }


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

    public Pane loadSectionsPane(){

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ForumApp.class.getResource("pane_sections.fxml"));
            Parent root = loader.load();
            SectionsPaneController sectionsPaneController = loader.getController();
            sectionsPaneController.setForumController(this);

            primaryPane.getChildren().clear();
            primaryPane.getChildren().add(root);
            return primaryPane;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loadTopicsPane(Section section){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ForumApp.class.getResource("pane_topics.fxml"));


        try {
            Parent root = loader.load();

            section.loadTopics(serverController);
            TopicsPaneController topicsPaneController = loader.getController();
            topicsPaneController.setForumController(this);
            topicsPaneController.setCurrentSection(section);
            topicsPaneController.init();

            primaryPane.getChildren().clear();
            primaryPane.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTopicsCreator(Section section){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ForumApp.class.getResource("pane_topics_create.fxml"));

        try{
            Pane root = loader.load();
            TopicsCreatorPaneController topicsCreatorPaneController = loader.getController();
            topicsCreatorPaneController.setForumController(this);
            Stage editStage = new Stage();
            topicsCreatorPaneController.setData(section, editStage);

            editStage.setScene(new Scene(root));
            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Long getUserId(){
        if(manager != null)
            return manager.userId;
        return 1L;
    }

}
