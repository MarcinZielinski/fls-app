package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Content;
import com.fls.forum.model.Post;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.Date;

public class PostView {

    public VBox getvBox() {
        return vBox;
    }

    private VBox vBox;
    private ApplicationController applicationController;


    public PostView(VBox vBox, ApplicationController applicationController){
        this.vBox = vBox;
        this.applicationController = applicationController;
    }

    public void showPost(Post post){
        String defalultStyle = "-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;";


        HBox hBox = new HBox();
        hBox.setMaxWidth(Double.MAX_VALUE);
        hBox.setPrefWidth(Double.MAX_VALUE);
        hBox.setPrefHeight(0.0f);
//        hBox.prefHeightProperty().bind(scrollPane.heightProperty().multiply(0.1));
//        hBox.prefWidthProperty().bind(scrollPane.widthProperty().multiply(0.1));
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
        Button editButton = new Button();
        editButton.visibleProperty().bind((post.authorIdProperty().isEqualTo(ForumApp.getUserId())));
        editButton.setOnAction(t -> {

            applicationController.loadEditPane(post);
        });
        editButton.setText("Edit");


        VBox buttons = new VBox(new HBox(addButton, minusButton), editButton);
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
}
