package com.fls.wall.controller;

import com.fls.util.ImageConverter;
import com.fls.wall.WallPost;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class WallPostController {
    @FXML
    public Circle avatar;
    public Label name;
    public Label content;
    public AnchorPane postView;

    @FXML
    private void initialize(){
        Platform.runLater(this::adjustSize);
        content.heightProperty().addListener((x) -> adjustSize());
        avatar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> model.getWall().getManager().loadProfile(model.getUser().getUserId()));
        name.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> model.getWall().getManager().loadProfile(model.getUser().getUserId()));
        name.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> name.setUnderline(true));
        name.addEventHandler(MouseEvent.MOUSE_EXITED, e -> name.setUnderline(false));
    }

    private WallPost model;

    public void setModel(WallPost model){
        this.model = model;
        updateControls();
    }

    private void adjustSize(){
        postView.setMinHeight(content.getHeight()+content.getLayoutY()+20);
        model.getWall().getwController().getPostsVBox().setSpacing(20);
    }

    private void updateControls(){
        avatar.setFill(new ImagePattern(ImageConverter.convertToImage(model.getUser().getImage())));
        name.setText(model.getUser().getFirstName() + " " + model.getUser().getLastName());
        content.setText(model.getContent());
    }
}