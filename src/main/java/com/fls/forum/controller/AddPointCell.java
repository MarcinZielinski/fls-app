package com.fls.forum.controller;

import com.fls.forum.model.Post;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class AddPointCell extends TableCell<Post, Boolean> {
    final Button cellButton = new Button("+");

    AddPointCell(){

        cellButton.setOnAction(t -> {
            ((Post)getTableRow().getItem()).addPlus();
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