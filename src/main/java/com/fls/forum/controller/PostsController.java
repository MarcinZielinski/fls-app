package com.fls.forum.controller;

import com.fls.forum.model.AnswerPost;
import com.fls.forum.model.Content;
import com.fls.forum.model.Post;
import com.fls.forum.model.QuestionPost;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Date;

public class PostsController {



    private long userId;
    private long topicId;



    private ObservableList<Post> posts;

    @FXML
    private TableView<Post> postsTable;

    @FXML
    private TableColumn<Post, String> authorColumn;

    @FXML
    private TableColumn<Post, Content> contentColumn;

    @FXML
    public TableColumn<Post, String> pointsColumn;

    @FXML
    public TableColumn<Post, Boolean> reviewColumn;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea sendText;

    @FXML
    private Label titleLabel;


    @FXML
    private void handleSendAction() {
        posts.add(new AnswerPost(topicId, 1, new Date(), userId, new Content(1, sendText.getText())));
    }


    @FXML
    private void initialize() {

        authorColumn.setCellValueFactory(dataValue -> dataValue.getValue().userIdProperty().asString());
        contentColumn.setCellValueFactory(dataValue -> dataValue.getValue().contentProperty());
        pointsColumn.setCellValueFactory(dataValue -> dataValue.getValue().plusCountProperty().asString());

        reviewColumn.setCellFactory(p -> new RemovePointCell(userId));
    }

    public void setData(int userId, int topicId, ObservableList<Post> posts) {
        this.userId = userId;
        this.topicId = topicId;
        this.posts = posts;
        postsTable.setItems(posts);

        titleLabel.setText(((QuestionPost)posts.get(0)).getTitle());
    }

    public ObservableList<Post> getPosts() {
        return posts;
    }

}
