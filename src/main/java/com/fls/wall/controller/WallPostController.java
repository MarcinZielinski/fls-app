package com.fls.wall.controller;

import com.fls.util.ImageConverter;
import com.fls.wall.WallPost;
import com.sun.javafx.stage.StageHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.Date;

public class WallPostController {
    @FXML
    public Circle avatar;
    public Label name;
    public Label content;
    public AnchorPane postView;
    public Label time;
    public MenuItem editAction;
    public MenuItem deleteAct;
    public SplitMenuButton menu;
    public ImageView postImage;
    public VBox postContainer;
    public Pane imagePane;
    private double ratio;
    private WallPost model;

    @FXML
    private void initialize() {
        Platform.runLater(this::adjustSize);
        content.heightProperty().addListener((x) -> adjustSize());
        avatar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> model.getWall().getManager().loadProfile(model.getUser().getUserId()));
        name.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> model.getWall().getManager().loadProfile(model.getUser().getUserId()));
        name.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> name.setUnderline(true));
        name.addEventHandler(MouseEvent.MOUSE_EXITED, e -> name.setUnderline(false));

        StageHelper.getStages().get(0).widthProperty().addListener(((observable, oldValue, newValue) -> Platform.runLater(() -> {
            postImage.setFitWidth(postContainer.getWidth());
            postContainer.setPrefHeight(postImage.getFitWidth() * ratio + postView.getHeight());
            postContainer.setMinHeight(postImage.getFitWidth() * ratio + postView.getHeight());
            postContainer.setMaxHeight(postImage.getFitWidth() * ratio + postView.getHeight());
        })));

        imagePane.widthProperty().addListener((observable, oldValue, newValue) -> {
            if (postImage.getImage() != null) {
                postImage.setFitWidth(postContainer.getWidth());
                postContainer.setPrefHeight(postImage.getFitWidth() * ratio + postView.getHeight());
                postContainer.setMinHeight(postImage.getFitWidth() * ratio + postView.getHeight());
                postContainer.setMaxHeight(postImage.getFitWidth() * ratio + postView.getHeight());
            }
        });

        editAction.setOnAction(e -> editPost());
        deleteAct.setOnAction(e -> deletePost());
    }

    public void setModel(WallPost model) {
        this.model = model;
        updateControls();
    }

    private void adjustSize() {
        postView.setMinHeight(content.getHeight() + content.getLayoutY() + 20);
        model.getWall().getwController().getPostsVBox().setSpacing(20);
        postContainer.setMinHeight(content.getHeight() + content.getLayoutY() + 20 + postImage.getFitHeight());
    }

    public void updateControls() {
        avatar.setFill(new ImagePattern(ImageConverter.convertToImage(model.getUser().getImage())));
        name.setText(model.getUser().getFirstName() + " " + model.getUser().getLastName());
        content.setText(model.getContent());
        postImage.setImage(model.getPostImage());
        if (model.getWall().getManager().userId == model.getUser().getUserId()) {
            menu.setDisable(false);
            menu.setVisible(true);
        }
        if (model.getTimestamp() != null) {
            time.setText((new Date(model.getTimestamp())).toString());
        }
    }

    private void editPost() {
        model.getWall().getwController().editPost(model);
    }

    private void deletePost() {
        model.getWall().getwController().deletePost(model);
    }

    public void calculateRatio(Image image) {
        if (image != null)
            ratio = image.getHeight() / image.getWidth();
    }
}
