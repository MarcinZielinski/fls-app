package com.fls.user_finder;

import com.fls.Server;
import com.fls.entities.User;
import com.fls.manager.Manager;
import com.fls.user_finder.contoller.UFController;
import com.fls.util.ImageConverter;
import com.fls.util.ThreadHelper;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    private Manager manager;
    private TitledPane searchResultsPane;
    private StackPane stackPane;
    private ThreadHelper actualTask;
    private TitledPane advancedSearchPane;


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
        advancedSearchPane = ufController.advancedSearchPane;

        searchForUsers(query);
        return rootPane;
    }

    private void fillWithQueryResult(VBox vBox, List<User> users) {
        byte[] image = ImageConverter.convertToByteArray(new ImageView("com/fls/user_finder/thmb.jpg"));
        users = Stream.of(new User(1L, 1L, "Andrzej", "Duda", image), new User(2L, 2L, "Andrzej", "Dudaszek", image), new User(1L, 1L, "Stefan", "Stefańczyk", image)).collect(Collectors.toCollection(ArrayList::new));
        vBox.getChildren().clear(); // clearing the results of the last search
        if (users != null) {
            vBox.setAlignment(Pos.TOP_LEFT);
            for (User user : users) {
                UFResult result = new UFResult(manager, user);
                vBox.getChildren().add(result.load());
            }
        } else {
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(new Label("No results :("));
        }
    }


    public void searchForUsers(String query) {
        if (query == null) { // the query is null when we want to run advanced search directly
            Platform.runLater(() -> advancedSearchPane.setExpanded(true));
            return;
        }
        String[] splitQuery = query.split(" ");
        String firstName = splitQuery[0];
        String lastName = query.length() > firstName.length() ? query.substring(splitQuery.length + 1) : "";

        searchForUsers(new User(firstName, lastName));
    }

    public void searchForUsers(User user) {
        user.setTokenId(manager.tokenId);

        Platform.runLater(() -> searchResultsPane.setExpanded(true)); // run later, when "later" means: run after FXMLLoader.invoke() method is called. invoke() sets "expanded" to false, so we need to change it to true after invoke() execution
        if (actualTask != null) actualTask.cancel();
        actualTask = new ThreadHelper<>(stackPane, () -> Server.getUsers(user), (users) -> fillWithQueryResult(vBox, users));
        actualTask.restart();
    }
}
