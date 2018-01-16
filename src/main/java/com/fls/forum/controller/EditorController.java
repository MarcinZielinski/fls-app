package com.fls.forum.controller;

import com.fls.forum.model.localModel.Content;
import com.fls.forum.model.localModel.Post;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class EditorController {

    private Post post;
    private Stage stage;

    private ForumController forumController;

    @FXML
    public TextArea textArea;

    @FXML
    public Button okButton;

    @FXML
    public Button cancelButton;

    public void handleOkAction() {
        post.setContent(new Content(textArea.getText()));
        stage.close();
        post.sendToServer(forumController.getServerController());
    }

    public void handleCancelAction() {
        stage.close();
    }

    public void setData(Post post, Stage stage){
        this.post = post;
        this.stage = stage;
        textArea.setText(post.getContent().toString());
    }

    public void setForumController(ForumController forumController) {
        this.forumController = forumController;
    }

}
