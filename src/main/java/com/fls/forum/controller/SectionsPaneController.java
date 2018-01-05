package com.fls.forum.controller;

import com.fls.forum.model.Section;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class SectionsPaneController implements Initializable {

    @FXML
    TableView tableview;

    @FXML
    private Label label;
    @FXML
    private TableColumn<Section, String> nameCol;// = new TableColumn("Name");
    @FXML
    private TableColumn<Section, String> descriptionCol;// = new TableColumn("Description");
    @FXML
    private TableColumn buttonCol;// = new TableColumn("Description");
//    TableColumn sendMailCol = new TableColumn("Action");


    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {




//        tableview.getColumns().addAll(nameCol, descriptionCol );



//        tableView.setItems(data);

//        buttonCol.setCellFactory(new Callback<TableColumn<Section, Boolean>, TableCell<Section, Boolean>>() {
//            @Override public TableCell<Section, Boolean> call(TableColumn<Section, Boolean> personBooleanTableColumn) {
//                return null;
//            }
//        });


//        TableColumn col_action = new TableColumn<>("Action");
        buttonCol.setSortable(false);

        buttonCol.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Section, Boolean>,
                ObservableValue<Boolean>>)
                p -> new SimpleBooleanProperty(p.getValue() != null));

        buttonCol.setCellFactory(
                (Callback<TableColumn<Section, Boolean>, TableCell<Section, Boolean>>)
                        p -> new ButtonCell());

//        tableview.getColumns().add(buttonCol);

        final ObservableList<Section> data = FXCollections.observableArrayList(
                new Section(2L, "Python", "python d"),
                new Section(1L, "Java", "Java d")
        );




        nameCol.setCellValueFactory(
                new PropertyValueFactory<Section,String>("name")
        );
        descriptionCol.setCellValueFactory(
                new PropertyValueFactory<Section,String>("description")
        );

//        sendMailCol.setCellValueFactory(
//                new PropertyValueFactory<Section,String>("buttonCol")
//        );

        tableview.setItems(data);


    }

    private class ButtonCell extends TableCell<Section, Boolean> {
        final Button cellButton = new Button("Action");

        ButtonCell(){

            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    System.out.println("hello");
                }
            });
        }

        //Display buttonCol if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }

    EventHandler<ActionEvent> btnNewHandler =
            new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    System.out.println("hello2");
                    //generate new Record with random number
//                    int newId = data.size();
//                    Record newRec = new Record(
//                            newId,
//                            random.nextInt(100),
//                            random.nextInt(100),
//                            random.nextInt(100),
//                            random.nextInt(100),
//                            random.nextInt(100));
//                    data.add(newRec);

                }
            };

}


