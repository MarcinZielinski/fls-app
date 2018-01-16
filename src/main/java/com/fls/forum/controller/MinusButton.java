package com.fls.forum.controller;

import com.fls.forum.model.localModel.Post;
import javafx.scene.control.Button;

public class MinusButton extends Button {

    MinusButton(Post post, Long userId) {

        this.setText("-");
        this.visibleProperty().bind(post.authorPlusProperty().not().and((post.authorIdProperty().isEqualTo(userId)).not()));

        setOnAction(t -> {

            post.removePlus(userId);
        });
    }
}
