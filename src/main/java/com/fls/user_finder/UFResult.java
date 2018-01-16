package com.fls.user_finder;

import com.fls.entities.User;
import com.fls.manager.Manager;
import com.fls.user_finder.contoller.UFResultContoller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class UFResult {
    private Manager manager;
    private User user;
    private FXMLLoader loader;
    private UFResultContoller controller;
    private Node root;

    public UFResult(Manager manager, User user) {
        this.manager = manager;
        this.user = user;
    }

    public Node load() {
        try {
            loader = new FXMLLoader(getClass().getResource("pane_userfinder_result.fxml"));
            root = loader.load();
            controller = loader.getController();
            controller.setManager(manager);
            controller.setUser(user);
            controller.updateView();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
