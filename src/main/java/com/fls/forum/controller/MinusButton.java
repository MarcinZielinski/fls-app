package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Post;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Button;

public class MinusButton extends Button {

    private Post post;


    MinusButton(Post post) {

        this.post = post;
        this.setText("-");
        this.visibleProperty().bind(post.authorPlusProperty().not().and((post.authorIdProperty().isEqualTo(ForumApp.getUserId())).not()));

        setOnAction(t -> {

            post.removePlus();
        });
    }
}
