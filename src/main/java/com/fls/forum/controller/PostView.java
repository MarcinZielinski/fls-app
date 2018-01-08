package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Content;
import com.fls.forum.model.Post;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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

    public HBox showPost(Post post){
//        String defalultStyle = "-fx-padding: 10;" + "-fx-border-style: solid inside;"
//                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
//                + "-fx-border-radius: 5;" + "-fx-border-color: blue;";
        String defalultStyle = "-fx-padding: 5; -fx-label-padding: 0; -fx-border-color: gray; -fx-border-width: 0 0 0 1;";


        HBox hBox = new HBox();
        hBox.setMaxWidth(Double.MAX_VALUE);
        hBox.setPrefWidth(Double.MAX_VALUE);
        hBox.setPrefHeight(100.0f);
//        hBox.prefHeightProperty().bind(vBox.heightProperty().divide(5.0));
//        hBox.prefHeightProperty().bind(scrollPane.heightProperty().multiply(0.1));
//        hBox.prefWidthProperty().bind(scrollPane.widthProperty().multiply(0.1));
        hBox.setStyle("-fx-border-color: black");

        Label authorLabel = new Label(Long.toString(post.getAuthorId()));
        authorLabel.textProperty().bind(new SimpleStringProperty("Author:\n").concat(post.authorIdProperty().asString()));
        authorLabel.setAlignment(Pos.TOP_LEFT);
        authorLabel.prefWidthProperty().bind(hBox.widthProperty().multiply(0.2));
//        authorLabel.setMaxWidth(Double.MAX_VALUE);
//        authorLabel.setPrefWidth(Double.MAX_VALUE);
//        authorLabel.setMaxWidth(Double.MAX_VALUE);

        authorLabel.setStyle(defalultStyle);
        authorLabel.prefHeightProperty().bind(hBox.heightProperty());

        TextArea contentLabel = new TextArea(post.getContent().toString());
        contentLabel.textProperty().bind(post.contentProperty().asString());
//        contentLabel.setAlignment(Pos.TOP_LEFT);
        contentLabel.maxWidthProperty().bind(hBox.widthProperty().multiply(0.5));
        contentLabel.minWidthProperty().bind(hBox.widthProperty().multiply(0.5));
        contentLabel.prefHeightProperty().bind(hBox.heightProperty());
        contentLabel.setStyle(authorLabel.getStyle());
        contentLabel.setEditable(false);

//        hBox.prefHeightProperty().bind(contentLabel.textProperty());

//        contentLabel.setWrapText(true);

        Label plusCountLabel = new Label(Long.toString(post.getPlusCount()));
        plusCountLabel.textProperty().bind(post.plusCountProperty().asString());
        plusCountLabel.prefWidthProperty().bind(hBox.widthProperty().multiply(0.1));
        plusCountLabel.setTextAlignment(TextAlignment.LEFT);
        plusCountLabel.setAlignment(Pos.CENTER);
        plusCountLabel.setStyle(defalultStyle);
        plusCountLabel.prefHeightProperty().bind(hBox.heightProperty());


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


        HBox plusMinusButtons = new HBox(addButton, minusButton);
        plusMinusButtons.setStyle("-fx-padding: 5");
        editButton.setStyle("-fx-padding: 5");
        Pane buttons = new Pane(plusMinusButtons, editButton);
        buttons.setStyle(defalultStyle);
        buttons.prefHeightProperty().bind(hBox.heightProperty());

//        buttons.setAlignment(Pos.TOP_RIGHT);
        buttons.prefWidthProperty().bind(hBox.widthProperty().multiply(0.1));
        buttons.prefHeightProperty().bind(hBox.heightProperty());

//        addButton.prefWidthProperty().bind(buttons.widthProperty().multiply(0.5));
        minusButton.prefWidthProperty().bind(addButton.widthProperty());
        addButton.setAlignment(Pos.CENTER);
        minusButton.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(buttons);

        for (Node child: hBox.getChildren()) {
            child.setStyle(defalultStyle);
        }
//        vBox.getChildren().addAll(hBox);

        return hBox;

    }
}
