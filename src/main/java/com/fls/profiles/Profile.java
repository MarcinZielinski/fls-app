package com.fls.profiles;


import com.fls.profiles.controller.DetailedController;
import com.fls.profiles.controller.EditController;
import com.fls.profiles.controller.InfoController;
import com.fls.profiles.controller.ProfileController;
import com.fls.profiles.model.IUser;
import com.fls.profiles.model.Programist;
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
    Stage primary;

    public Profile(Stage prim){
        primary = prim;
    }

    public Profile(){}
    @Override
    public Pane getProfile(IUser user) {
        Pane layout = new Pane();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/profile.fxml"));
            layout = (Pane) loader.load();

            ProfileController controller = (ProfileController) loader.getController();

            controller.setUser(user);
            controller.setStage(primary);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layout;
    }

    @Override
    public Pane getInfo(IUser user) {
        Pane layout = new Pane();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/info.fxml"));
            layout = (Pane) loader.load();

            // set initial data into controller
            InfoController controller = (InfoController) loader.getController();
            controller.setUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layout;
    }

    @Override
    public Pane getDetailedInfo(int user_id) {
        Pane layout = new Pane();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/detailed.fxml"));
            layout = (Pane) loader.load();

            // set initial data into controller
            DetailedController controller = (DetailedController) loader.getController();
            Set<String> spoken = new HashSet<>(), programming = new HashSet<>();
            spoken.add("polish"); spoken.add("english"); spoken.add("esperanto");
            programming.add("c++"); programming.add("java"); programming.add("icon");
            File file = new File("avatar.jpg");
            //byte[] buffer = Files.readAllBytes(fi.toPath());
            //Image img = new Image(new ByteArrayInputStream(buffer));
            Image img = new Image(file.toURI().toString());

            Programist prog = new Programist(1,"stefek111", "qwerty","Stefan", "Stefkowski",
                    "20-12-1990", "stefan@agh.edu.pl","123456789", "Stefkowa 5", "Stefanowo",
                    "Poland", FXCollections.observableSet(spoken), FXCollections.observableSet(programming),
                    10, 99999, 63, 28, img, new ArrayList<>());
            controller.setUser(prog);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layout;
    }

    @Override
    public IUser register() {
        return null;
    }

    public void editDialog(IUser user){
        Pane layout = new Pane();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/edit.fxml"));
            layout = (Pane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit profile");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primary);
            Scene scene = new Scene(layout);
            dialogStage.setScene(scene);
            EditController controller = (EditController) loader.getController();
            if(user != null) controller.setUser(user);
            controller.setStage(dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
