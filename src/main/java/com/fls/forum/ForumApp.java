package com.fls.forum;

import com.fls.forum.view.SectionsPane;
import com.fls.manager.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ForumApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {

//        ObservableList<Section> data = FXCollections.observableArrayList();
//        data.addAll(new Section(2L, "Python", "python d"), new Section(1L, "Java", "Java d"));
//
//        final ListView<Section> listView = new ListView<Section>(data);
//        listView.setCellFactory(new Callback<ListView<Section>, ListCell<Section>>() {
//
//            @Override
//            public ListCell<Section> call(ListView<Section> arg0) {
//                return new ListCell<Section>() {
//
//                    @Override
//                    protected void updateItem(Section item, boolean bln) {
//                        super.updateItem(item, bln);
//                        if (item != null) {
//                            VBox vBox = new VBox(new Text(item.getName()), new Text(item.getDescription()));
//                            HBox hBox = new HBox(new Label("[Graphic]"), vBox);
//                            hBox.setSpacing(10);
//                            setGraphic(hBox);
//                        }
//                    }
//                };
//            }
//
//        });
//
//        StackPane root = new StackPane();
//        root.getChildren().add(listView);
//        primaryStage.setScene(new Scene(root, 200, 250));
//        primaryStage.show();
        Parent root = FXMLLoader.load(getClass().getResource("forum.fxml"));
        Scene scene = new Scene(root);
        stage = primaryStage;
        stage.setTitle("FLSocial");
        stage.setScene(scene);
        stage.show();
    }
    private void loadUserAuthentication() {

        SectionsPane sectionsPane = new SectionsPane();
        stage.setScene(sectionsPane.getScene());
    }
    public void loadManager(Long tokenId, Long userId) {
        Manager manager = new Manager(null, 1L, 1L);
        stage.setScene(manager.getScene());
    }
}
