package com.fls.forum.controller;

import com.fls.forum.model.Post;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class RemovePointCell extends TableCell<Post, Boolean> {
    final Button cellButton = new Button("-");

    RemovePointCell(){

        cellButton.setOnAction(t -> {
            ((Post)getTableRow().getItem()).removePlus();
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