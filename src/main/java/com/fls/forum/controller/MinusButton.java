package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Post;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Button;

public class MinusButton extends Button {

    //    private final Button cellButtonMinus = new Button("-");
//    private final Button cellButtonPlus = new Button("+");
//    private HBox pane = new HBox(cellButtonMinus, cellButtonPlus);
    Post post;


    MinusButton(Post post) {

        this.post = post;
        this.setText("-");
//        BooleanBinding b = Bindings.createBooleanBinding( () -> (!post.getAuthorId().equals(ForumApp.getUserId())) && !post.plusAuthorsProperty().get().contains( ForumApp.getUserId() ));
        this.visibleProperty().bind(post.authorPlusProperty().not().and((post.authorIdProperty().isEqualTo(ForumApp.getUserId())).not()));

        setOnAction(t -> {

            post.removePlus();
        });
    }
}
