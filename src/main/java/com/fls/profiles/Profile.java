package com.fls.profiles;


import com.fls.manager.Manager;
import com.fls.profiles.controller.DetailedController;
import com.fls.profiles.controller.EditController;
import com.fls.profiles.controller.InfoController;
import com.fls.profiles.controller.ProfileController;
import com.fls.profiles.model.IUser;
import com.fls.profiles.model.Programist;
import com.sun.javafx.stage.StageHelper;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Profile implements IProfile {
    public final Manager manager;

    public Profile(Manager manager) {
        this.manager = manager;
    }

    @Override
    public Pane getProfile(long id) {
        Pane layout = new Pane();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/fls/profile/profile.fxml"));
            layout = (Pane) loader.load();

            ProfileController controller = (ProfileController) loader.getController();
            controller.setProfile(this);

            //controller.setUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layout;
    }

    @Override
    public Pane getInfo(long id) {
        Pane layout = new Pane();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Profile.class.getResource("/com/fls/profile/info.fxml"));
            layout = (Pane) loader.load();

            // set initial data into controller
            InfoController controller = (InfoController) loader.getController();
            //controller.setUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layout;
    }

    @Override
    public Pane getDetailedInfo(long id) {
        Pane layout = new Pane();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Profile.class.getResource("/com/fls/profile/detailed.fxml"));
            layout = (Pane) loader.load();

            // set initial data into controller
            DetailedController controller = (DetailedController) loader.getController();
            //controller.setUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layout;
    }

    @Override
    public IUser register() {
        return null;
    }

    public void editDialog(long id){
        Pane layout = new Pane();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Profile.class.getResource("/com/fls/profile/edit.fxml"));
            layout = (Pane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit profile");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(StageHelper.getStages().get(0));
            Scene scene = new Scene(layout);
            dialogStage.setScene(scene);
            EditController controller = (EditController) loader.getController();
            //controller.setUser(user);
            controller.setStage(dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
