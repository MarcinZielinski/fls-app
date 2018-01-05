package com.fls.forum.controller;

import com.fls.forum.model.AnswerPost;
import com.fls.forum.model.Content;
import com.fls.forum.model.Post;
import com.fls.forum.model.QuestionPost;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

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
    public TableColumn<Post, Boolean> addPointColumn;

    @FXML
    public TableColumn<Post, Boolean> removePointColumn;

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

        addPointColumn.setCellValueFactory(p -> new SimpleBooleanProperty(p.getValue() != null));

        addPointColumn.setCellFactory(p -> new AddPointCell());

        removePointColumn.setCellValueFactory(p -> new SimpleBooleanProperty(p.getValue() != null));

        removePointColumn.setCellFactory(p -> new RemovePointCell());

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
