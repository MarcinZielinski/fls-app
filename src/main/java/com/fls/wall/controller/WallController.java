package com.fls.wall.controller;

import com.fls.Server;
import com.fls.entities.User;
import com.fls.util.ImageConverter;
import com.fls.wall.Wall;
import com.fls.wall.WallPost;
import com.sun.javafx.stage.StageHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import javax.annotation.Generated;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Marcin on 2017-12-12.
 */
public class WallController {
    @FXML
    public StackPane stackPane;
    public TitledPane postsPane;
    public Button addImage;
    public VBox creatorSections;
    public ImageView imageView;
    public Button apply;
    public TextArea content;
    public TitledPane creatorPane;
    private WallPost actualWallPost;


    private Wall model;

    @FXML
    private VBox posts;

    @FXML
    void initialize(){
        posts.layoutYProperty().addListener(( x ) -> posts.setLayoutY(0));
        addImage.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> showImageChooser());
        //imageView.
        imageView.fitWidthProperty().bind(creatorSections.widthProperty());
        apply.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> postCreator());
    }

    private void postCreator(){
        if(actualWallPost==null){
            WallPost wp = new WallPost(Server.getUser(model.getManager().userId), content.getText(), model);
            byte[] image = ImageConverter.convertToByteArray(new ImageView("com/fls/user_finder/thmb.jpg"));
            wp = new WallPost(new User(0L, 0L, "Kamil", "Wróbel", image), content.getText(), model);
            //Long timeStamp = Server.createPost(wp);
            Long timeStamp = System.currentTimeMillis();
            wp.setTimestamp(timeStamp);
            model.addPost(wp);
            clearCreator();
        }
        else{
            actualWallPost.setContent(content.getText());
            actualWallPost.getWallPostController().updateControls();
            model.refreshPosts();
            clearCreator();
            actualWallPost = null;
        }
    }

    private void clearCreator(){
        content.setText(null);
        imageView.setImage(null);
    }

    public void loadPosts(List<WallPost> posts){
        this.posts.getChildren().clear();
        if(posts != null) {
            for (WallPost wallPost : posts) {
                this.posts.getChildren().add(wallPost.load());
            }
        }
    }

    public void setModel(Wall model){
        this.model = model;
    }
    void updateModel(){

    }

    public VBox getPostsVBox(){
        return posts;
    }

    private void showImageChooser(){
        File file = (new FileChooser()).showOpenDialog(StageHelper.getStages().get(0));
        try {
            FileInputStream fis = new FileInputStream(file);
            imageView.setImage(new Image(fis));
            //creatorSections.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void editPost(WallPost wp){
        actualWallPost = wp;
        content.setText(actualWallPost.getContent());
        creatorPane.setExpanded(true);
    }

    public void deletePost(WallPost wp){
        model.deletePost(wp);
    }

}
