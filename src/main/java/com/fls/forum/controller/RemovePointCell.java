package com.fls.forum.controller;

import com.fls.forum.model.Post;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

public class RemovePointCell extends TableCell<Post, Boolean> {
    private final Button cellButtonMinus = new Button("-");
    private final Button cellButtonPlus = new Button("+");
    private HBox pane = new HBox(cellButtonPlus, cellButtonMinus);
    private long userId;

    RemovePointCell(long userId){

        this.userId = userId;

        cellButtonMinus.setOnAction(t -> {
            ((Post)getTableRow().getItem()).removePlus();
        });

        cellButtonPlus.setOnAction(t -> {
            ((Post)getTableRow().getItem()).addPlus();
        });
    }
    //Display buttonCol if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if(!empty && ((Post)getTableRow().getItem()).getUserId() != userId)
            setGraphic(pane);
    }
}