package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.AnswerPost;
import com.fls.forum.model.Content;
import com.fls.forum.model.Post;
import com.fls.forum.model.QuestionPost;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.Date;

public class PostsController {



    private Long userId;
    private Long topicId;
    private PostView postView;



    private ObservableList<Post> posts = FXCollections.observableArrayList();

    @FXML
    private Pane mainPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextArea answerText;

    @FXML
    private Label titleLabel;

    @FXML
    private VBox vBox;
    private ApplicationController applicationController;


    @FXML
    private void handleSendAction() {
        addPost(new AnswerPost(topicId, 1, new Date(), userId, new Content(1, answerText.getText()), false));
        System.out.println("hello");
    }


    @FXML
    private void initialize() {
        vBox.prefWidthProperty().bind(scrollPane.widthProperty());
        vBox.prefHeightProperty().bind(scrollPane.heightProperty());

        scrollPane.prefWidthProperty().bind(mainPane.widthProperty().multiply(0.9));
        scrollPane.prefHeightProperty().bind(mainPane.heightProperty().multiply(0.7));

        scrollPane.setFitToWidth(true);

    }

    public void setApplicationController(ApplicationController applicationController){
        this.applicationController = applicationController;
    }


    public void addPost(Post post){

        posts.add(post);

        postView.showPost(post);
    }

    public void setData(Long userId, Long topicId, ObservableList<Post> posts) {
        this.userId = userId;
        this.topicId = topicId;
        postView = new PostView(vBox, applicationController);
        for(Post post: posts) {
            addPost(post);
        }

        titleLabel.setText(((QuestionPost)posts.get(0)).getTitle());
    }

    public ObservableList<Post> getPosts() {
        return posts;
    }

}
