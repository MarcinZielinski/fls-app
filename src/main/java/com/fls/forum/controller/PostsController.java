package com.fls.forum.controller;

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

//        scrollPane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
//                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
//                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

    }


    public void addPost(Post post){

        posts.add(post);

        String defalultStyle = "-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;";


        HBox hBox = new HBox();
        hBox.setMaxWidth(Double.MAX_VALUE);
        hBox.setPrefWidth(Double.MAX_VALUE);
        hBox.prefHeightProperty().bind(scrollPane.heightProperty().multiply(0.1));
        hBox.prefWidthProperty().bind(scrollPane.widthProperty().multiply(0.1));
        hBox.setStyle(defalultStyle);

        Label authorLabel = new Label(Long.toString(post.getAuthorId()));
        authorLabel.textProperty().bind(post.authorIdProperty().asString());
        authorLabel.setAlignment(Pos.BOTTOM_RIGHT);
        authorLabel.prefWidthProperty().bind(hBox.prefWidthProperty().multiply(0.2));
//        authorLabel.setMaxWidth(Double.MAX_VALUE);
//        authorLabel.setPrefWidth(Double.MAX_VALUE);
//        authorLabel.setMaxWidth(Double.MAX_VALUE);

        authorLabel.setStyle(defalultStyle);

        Label contentLabel = new Label(post.getContent().toString());
        contentLabel.textProperty().bind(post.contentProperty().asString());
        contentLabel.setAlignment(Pos.TOP_CENTER);
        contentLabel.minWidthProperty().bind(hBox.widthProperty().multiply(0.5));
        contentLabel.setStyle(defalultStyle);

        Label plusCountLabel = new Label(Long.toString(post.getPlusCount()));
        plusCountLabel.textProperty().bind(post.plusCountProperty().asString());
        plusCountLabel.prefWidthProperty().bind(hBox.widthProperty().multiply(0.1));
        plusCountLabel.setTextAlignment(TextAlignment.LEFT);
        plusCountLabel.setAlignment(Pos.TOP_RIGHT);
        plusCountLabel.setStyle(defalultStyle);


        hBox.getChildren().add(authorLabel);
        hBox.getChildren().add(contentLabel);
        hBox.getChildren().add(plusCountLabel);

        Button addButton = new AddButton(post);
        Button minusButton = new MinusButton(post);


        VBox buttons = new VBox(addButton, minusButton);
        buttons.setStyle(defalultStyle);

//        buttons.setAlignment(Pos.TOP_RIGHT);
        buttons.prefWidthProperty().bind(hBox.widthProperty().multiply(0.1));
        buttons.prefHeightProperty().bind(hBox.heightProperty());

//        addButton.prefWidthProperty().bind(buttons.widthProperty().multiply(0.5));
        minusButton.prefWidthProperty().bind(addButton.widthProperty());
        addButton.setAlignment(Pos.CENTER);
        minusButton.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(buttons);

        vBox.getChildren().addAll(hBox);
    }

    public void setData(Long userId, Long topicId, ObservableList<Post> posts) {
        this.userId = userId;
        this.topicId = topicId;

        for(Post post: posts) {
            addPost(post);
        }

        titleLabel.setText(((QuestionPost)posts.get(0)).getTitle());
    }

    public ObservableList<Post> getPosts() {
        return posts;
    }

}
