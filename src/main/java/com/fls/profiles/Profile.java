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
    private ArrayList<IUser> mockUsers = new ArrayList<>();

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

            Set<String> spoken = new HashSet<>(), programming = new HashSet<>();
            spoken.add("polish"); spoken.add("english"); spoken.add("esperanto");
            programming.add("c++"); programming.add("java"); programming.add("icon");
            File file = new File("/com/fls/profile/avatar.jpg");
            Image img = new Image(file.toURI().toString());

            ArrayList<Long> friends = new ArrayList<>();
            friends.add(0L);
            friends.add(1L);

            Programist prog = new Programist(1,"stefek111", "qwerty","Stefan", "Stefkowski", "20-12-1990", "stefan@agh.edu.pl",
                    "123456789", "Stefkowa 5", "Stefanowo", "Poland", spoken, programming,
                    10, 99999, 63, 28, img, friends);

            controller.setUser(prog);
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
            Set<String> spoken = new HashSet<>(), programming = new HashSet<>();
            spoken.add("polish"); spoken.add("english"); spoken.add("esperanto");
            programming.add("c++"); programming.add("java"); programming.add("icon");
            File file = new File("/com/fls/profile/avatar.jpg");
            Image img = new Image(file.toURI().toString());
            Programist prog1 = new Programist(1,"stefek111", "qwerty","Stefan", "Stefkowski", "20-12-1990", "stefan@agh.edu.pl",
                    "123456789", "Stefkowa 5", "Stefanowo", "Poland", spoken, programming,
                    10, 99999, 63, 28, img, new ArrayList<>());

            // set initial data into controller
            InfoController controller = (InfoController) loader.getController();
            controller.setUser(prog1);
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
            Set<String> spoken = new HashSet<>(), programming = new HashSet<>();
            spoken.add("polish"); spoken.add("english"); spoken.add("esperanto");
            programming.add("c++"); programming.add("java"); programming.add("icon");
            File file = new File("/com/fls/profile/avatar.jpg");
            Image img = new Image(file.toURI().toString());
            Programist prog1 = new Programist(1,"stefek111", "qwerty","Stefan", "Stefkowski", "20-12-1990", "stefan@agh.edu.pl",
                    "123456789", "Stefkowa 5", "Stefanowo", "Poland", spoken, programming,
                    10, 99999, 63, 28, img, new ArrayList<>());

            // set initial data into controller
            DetailedController controller = (DetailedController) loader.getController();
            controller.setUser(prog1);
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
            Set<String> spoken = new HashSet<>(), programming = new HashSet<>();
            spoken.add("polish"); spoken.add("english"); spoken.add("esperanto");
            programming.add("c++"); programming.add("java"); programming.add("icon");
            File file = new File("/com/fls/profile/avatar.jpg");
            Image img = new Image(file.toURI().toString());

            ArrayList<Long> friends = new ArrayList<>();
            friends.add(0L);
            friends.add(1L);

            Programist prog = new Programist(1,"stefek111", "qwerty","Stefan", "Stefkowski", "20-12-1990", "stefan@agh.edu.pl",
                    "123456789", "Stefkowa 5", "Stefanowo", "Poland", spoken, programming,
                    10, 99999, 63, 28, img, friends);
            controller.setUser(prog);
            controller.setStage(dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
