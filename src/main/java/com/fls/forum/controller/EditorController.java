package com.fls.forum.controller;

import com.fls.forum.model.localModel.Content;
import com.fls.forum.model.localModel.Post;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class EditorController {

    @FXML
    public TextArea textArea;
    @FXML
    public Button okButton;
    @FXML
    public Button cancelButton;
    private Post post;
    private Stage stage;

    public void handleOkAction() {
        post.setContent(new Content(textArea.getText()));
        stage.close();
    }

    public void handleCancelAction() {
        stage.close();
    }

    public void setData(Post post, Stage stage) {
        this.post = post;
        this.stage = stage;
        textArea.setText(post.getContent().toString());
    }

}
