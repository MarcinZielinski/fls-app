package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Post;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

public class ReviewCell extends TableCell<Post, Boolean> {
    private final Button cellButtonMinus = new Button("-");
    private final Button cellButtonPlus = new Button("+");
    private HBox pane = new HBox(cellButtonMinus, cellButtonPlus);



    ReviewCell(){


        cellButtonMinus.setOnAction(t -> {
//            System.out.println(getTableRow().toString());
            ((Post)getTableRow().getItem()).removePlus();
        });

        cellButtonPlus.setOnAction(t -> {
            ((Post)getTableRow().getItem()).addPlus();
//            setGraphic(null);
        });





    }
    //Display buttonCol if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if(!empty && ((Post)getTableRow().getItem())  != null && ((Post)getTableRow().getItem()).getAuthorId() != ForumApp.getUserId() && !((Post)getTableRow().getItem()).getPlusAuthors().contains(ForumApp.getUserId())){// && ((Post)getTableRow().getItem()).getAuthorId() != ForumApp.getUserId()) {
            System.out.println(((Post)getTableRow().getItem()).getAuthorId());
            System.out.println(ForumApp.getUserId());
//            getTableView().refresh();
            setGraphic(pane);
        }
        else
            setGraphic(null);
    }
}