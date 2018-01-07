package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Post;
import javafx.scene.control.Button;

public class AddButton extends Button{

    private Post post;

    AddButton(Post post){

        this.post = post;
        this.setText("+");

        this.visibleProperty().bind(post.authorPlusProperty().not().and((post.authorIdProperty().isEqualTo(ForumApp.getUserId())).not()));
        setOnAction(t -> {
            post.addPlus();
        });

    }

}
