package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Post;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class AddButton extends Button{

//    private final Button cellButtonMinus = new Button("-");
//    private final Button cellButtonPlus = new Button("+");
//    private HBox pane = new HBox(cellButtonMinus, cellButtonPlus);
    Post post;


    AddButton(Post post){

        this.post = post;
        this.setText("+");
//
//        BooleanBinding b = Bindings.createBooleanBinding( () -> (!post.plusAuthorsProperty().contains( ForumApp.getUserId() )));
//
//        this.visibleProperty().bind(b);
        this.visibleProperty().bind(post.authorPlusProperty().not().and((post.authorIdProperty().isEqualTo(ForumApp.getUserId())).not()));
        setOnAction(t -> {
            post.addPlus();
        });

    }

}
