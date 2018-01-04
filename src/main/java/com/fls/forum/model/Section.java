package com.fls.forum.model;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Section {
    private final SimpleLongProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty description;
    private Button button;


    public Section(long id, String name, String description) {
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.button = new Button("Send Mail");

        button.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                System.out.println("hello");
            }
        });


    }

    public String getName() {
        return name.get();
    }
    public void setName(String fName) {
        name.set(fName);
    }

    public String getDescription() {
        return description.get();
    }
    public void setDescription(String fName) {
        description.set(fName);
    }

    public void setButton(Button button)
    {
        this.button = button;

    }

    public Button getButton(){

        return button;
    }


    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }
}