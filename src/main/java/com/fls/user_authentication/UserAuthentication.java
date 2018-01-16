package com.fls.user_authentication;

import com.fls.Main;
import com.fls.manager.controller.UAController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by Marcin on 2017-12-12.
 */
public class UserAuthentication {
    private Main main;
    private Scene scene;
    private Pane rootLayout;
    private UAController uaController;

    public UserAuthentication(Main main) {
        this.main = main;
        try {
            FXMLLoader loader = new FXMLLoader(UserAuthentication.class.getResource("ua.fxml"));
            rootLayout = loader.load();
            uaController = loader.getController();
            uaController.setModel(this);
            this.scene = new Scene(rootLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }

    public void login(long tokenId, long userId) {
        main.loadManager(tokenId, userId);
    }
}
