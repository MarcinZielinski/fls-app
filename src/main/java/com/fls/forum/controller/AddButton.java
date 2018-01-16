package com.fls.forum.controller;

import com.fls.forum.model.localModel.Post;
import javafx.scene.control.Button;

public class AddButton extends Button {

    AddButton(Post post, Long userId) {

        this.setText("+");

        this.visibleProperty().bind(post.authorPlusProperty().not().and((post.authorIdProperty().isEqualTo(userId)).not()));
        setOnAction(t -> {
            post.addPlus(userId);
        });

    }

}
