package com.fls.user_finder.contoller;

import com.fls.entities.User;
import com.fls.manager.Manager;
import com.fls.util.ImageConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


public class UFResultContoller {
    @FXML
    public HBox parentHBox;
    @FXML
    private Label nameLabel;
    @FXML
    private ImageView avatar;

    private Manager manager;
    private User user;

    public void mouseClicked(MouseEvent mouseEvent) {
        manager.loadProfile(user.getUserId());
    }

    public void mouseExited(MouseEvent mouseEvent) {
        parentHBox.setOpacity(1);
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        parentHBox.setOpacity(0.8);
    }

    public void mousePressed(MouseEvent mouseEvent) {
        parentHBox.setOpacity(0.5);
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        parentHBox.setOpacity(1);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void updateView() {
        nameLabel.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
        avatar.setImage(ImageConverter.convertToImage(user.getImage()));
    }

}
