package com.fls.wall.controller;

import com.fls.util.ImageConverter;
import com.fls.wall.WallPost;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class WallPostController {
    @FXML
    private Circle avatar;

    @FXML
    private Label name;

    @FXML
    private Label content;

    @FXML
    private AnchorPane postView;

    @FXML
    private void initialize(){
        Platform.runLater(this::adjustSize);
        content.heightProperty().addListener((x) -> adjustSize());
    }

    private WallPost model;

    public void setModel(WallPost model){
        this.model = model;
        updateControls();
    }

    private void adjustSize(){
        postView.setMinHeight(content.getHeight()+content.getLayoutY()+20);
    }

    private void updateControls(){
        avatar.setFill(new ImagePattern(ImageConverter.convertToImage(model.getUser().getImage())));
        name.setText(model.getUser().getFirstName() + " " + model.getUser().getLastName());
        content.setText(model.getContent());
    }
}
