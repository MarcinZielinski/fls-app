package com.fls.manager.controller;

import com.fls.manager.Manager;
import com.fls.manager.SideBar;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SideMenuController {

    @FXML
    public GridPane sideGrid;
    public HBox sideHBox;

    private Manager model;
    private Pane sidePane;
    private SideBar sideBar;

    @FXML
    public void initialize() {
        sideBar = new SideBar(100, sideGrid);
        sidePane = new Pane();
        sidePane.setBackground(new Background(new BackgroundImage(new Image("/com/fls/manager/arrows.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(20,40,false,false,false,false))));
        sidePane.setPrefWidth(20);

        sideHBox.getChildren().addAll(sideBar, sidePane);

        sideBar.setId("sideBarPane");
    }

    public void yourProfileClicked(MouseEvent mouseEvent) {
        model.loadProfile(model.userId);
    }

    public void chatClicked(MouseEvent mouseEvent) {
        model.loadChat(null);
    }

    public void forumClicked(MouseEvent mouseEvent) {
        model.loadForum();
    }

    public void wallClicked(MouseEvent mouseEvent) {
        model.loadWall();
    }

    public void findUserClicked(MouseEvent mouseEvent) {
        model.loadUserFinder(null);
    }

    public void mousePressed(MouseEvent mouseEvent) {
        AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();
        anchorPane.setOpacity(0.5);
   }

    public void mouseReleased(MouseEvent mouseEvent) {
        AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();
        anchorPane.setOpacity(1);
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();
        anchorPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void mouseExited(MouseEvent mouseEvent) {
        AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();
        anchorPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void setModel(Manager model) {
        this.model = model;
    }


    public void openSideBar(MouseEvent mouseEvent) {
        sideBar.open();
    }

    public void closeSideBar(MouseEvent mouseEvent) {
        sideBar.close();
    }
}
