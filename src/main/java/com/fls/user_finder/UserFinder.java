package com.fls.user_finder;

import com.fls.Server;
import com.fls.entities.User;
import com.fls.manager.Manager;
import com.fls.util.ImageConverter;
import com.fls.util.ThreadHelper;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

/**
 * Created by Marcin on 2017-12-12.
 */
public class UserFinder {
    private Pane rootPane;
    private UFController ufController;
    private VBox vBox;
    private Manager manager;
    private TitledPane searchResultsPane;
    private StackPane stackPane;
    private ThreadHelper actualTask;

    public UserFinder() {

    }

    public UserFinder(Manager manager) {
        this.manager = manager;
    }

    public Pane load(String query) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_userfinder.fxml"));
        try {
            rootPane = loader.load();
            ufController = loader.getController();
            ufController.setModel(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        vBox = ufController.searchResultsVBox;
        searchResultsPane = ufController.resultsPane;
        stackPane = ufController.stackPane;

        searchForUsers(query);
        return rootPane;
    }

    private void fillWithQueryResult(VBox vBox, List<User> users) {
        vBox.getChildren().clear(); // clearing the results of the last search
        if(users!=null) {
            for (User user : users) {
                vBox.setAlignment(Pos.TOP_LEFT);
                Label label1 = new Label(String.format("%s %s", user.getFirstName(), user.getLastName()));
                ImageView imageView = ImageConverter.convertToImageView(user.getImage());
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                HBox hBox = new HBox(imageView, label1);
                hBox.setAlignment(Pos.CENTER_LEFT);
                hBox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> manager.loadProfile(user.getUserId()));
                hBox.setStyle("-fx-background-color: lightgray");
                hBox.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> hBox.setOpacity(0.5));
                hBox.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> hBox.setOpacity(1));
                hBox.setSpacing(20);
                vBox.getChildren().add(hBox);
            }
        } else {
            Label label = new Label("No results :(");
            vBox.getChildren().add(label);
            vBox.setAlignment(Pos.CENTER);
        }
    }


    public void searchForUsers(String query) {
        String[] splitQuery = query.split(" ");
        String firstName = splitQuery[0];
        String lastName = query.length() > firstName.length() ? query.substring(splitQuery.length+1) : "";

        searchForUsers(new User(firstName, lastName));
    }

    public void searchForUsers(User user) {
        user.setTokenId(manager.tokenId);

        vBox.getChildren().clear(); // clearing the results of the last search
        Platform.runLater(() -> searchResultsPane.setExpanded(true)); // run later, when "later" means: run after FXMLLoader.invoke() method is called. invoke() sets "expanded" to false, so we need to change it to true after invoke() execution
        if(actualTask != null) actualTask.cancel();
        actualTask = new ThreadHelper<>(stackPane, () -> Server.getUsers(user), (users) -> fillWithQueryResult(vBox, users));
        actualTask.restart();
    }
}
