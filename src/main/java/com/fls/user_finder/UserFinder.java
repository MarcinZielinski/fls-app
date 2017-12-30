package com.fls.user_finder;

import com.fls.Server;
import com.fls.entities.User;
import com.fls.util.ImageConverter;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Marcin on 2017-12-12.
 */
public class UserFinder {
    private Pane rootPane;
    private UFController ufController;
    private VBox vBox;

    public UserFinder() {

    }

    public Pane load(String query) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_userfinder.fxml"));
        try {
            rootPane = loader.load();
            ufController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        vBox = ufController.vBox;

        List<User> users = getQueryResults(query);

        byte[] image = ImageConverter.convertToByteArray(new ImageView("com/fls/user_finder/thmb.jpg"));
        users = Stream.of(new User(1L, 1L, "Andrzej", "Duda", image), new User(2L, 2L, "Andrzej", "Dudaszek", image)).collect(Collectors.toCollection(ArrayList::new));
        fillWithQueryResult(vBox, users);
        return rootPane;
    }

    private List<User> getQueryResults(String query){
        return Server.getUsers(query);
    }

    private void fillWithQueryResult(VBox vBox, List<User> users) {
        for(User user : users) {
            Label label1 = new Label(String.format("%s %s",user.getFirstName(), user.getLastName()));
            ImageView imageView = ImageConverter.convertToImageView(user.getImage());
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            HBox hBox = new HBox(imageView, label1);
            hBox.alignmentProperty().set(Pos.CENTER);
            hBox.spacingProperty().setValue(20);
            vBox.getChildren().add(hBox);
        }
    }
}
