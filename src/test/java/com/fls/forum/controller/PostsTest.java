package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.Post;
import com.fls.forum.model.generator.DataGenerator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;


public class PostsTest extends ApplicationTest {
    private PostsController postsController;
    private List<Post> posts;
    private VBox vBox;

    @Override public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ForumApp.class.getResource("pane_posts.fxml"));


        Pane root;
        root = loader.load();

        postsController = loader.getController();
//        postsController.setApplicationController(this);
        postsController.setData(1L, 1L, DataGenerator.generatePosts());
        posts = postsController.getPosts();
        vBox = postsController.getVbox();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }




    @Test
    public void sendTextButton() {
        // expect:
        verifyThat(".button:send", hasText("Send"));
    }


    @Test
    public void sendEmptyMessageControl(){

        // when:
        clickOn("#send");

        // expect:
        verifyThat("#errorLabel", hasText("You cannot send empty message"));
    }

    @Test
    public void sendEmptyMessage(){

        //given
        int postCount = posts.size();

        // when:
        clickOn("#answerText");
        write("hello");
        eraseText(10);
        clickOn("#send");

        // expect:
        assertEquals(postCount, posts.size());
    }

    @Test
    public void sendMessageTest(){

        //given
        int postCount = posts.size();

        // when:
        clickOn("#answerText");
        write("hello");
        clickOn("#send");

        // expect:
        assertEquals(postCount + 1, posts.size());
    }

    @Test
    public void invisiblePlusTest(){
        // given
        Button firstAddButton = (Button) (((HBox)(((VBox)((HBox)vBox.getChildren().get(0)).getChildren().get(3)).getChildren().get(0))).getChildren().get(0));

        //when

        // then:
        assert (firstAddButton.isVisible());
    }

    @Test
    public void visiblePlusTest(){
        // given
        Button secondAddButton = (Button) (((HBox)(((VBox)((HBox)vBox.getChildren().get(1)).getChildren().get(3)).getChildren().get(0))).getChildren().get(0));
        Button secondMinusButton = (Button) (((HBox)(((VBox)((HBox)vBox.getChildren().get(1)).getChildren().get(3)).getChildren().get(0))).getChildren().get(1));

        //when

        // then:
        assert (secondAddButton.isVisible());
        assert (secondMinusButton.isVisible());
    }

    @Test
    public void givePlusTest(){
        // given
        Button secondAddButton = (Button) (((HBox)(((VBox)((HBox)vBox.getChildren().get(1)).getChildren().get(3)).getChildren().get(0))).getChildren().get(0));
        Button secondMinusButton = (Button) (((HBox)(((VBox)((HBox)vBox.getChildren().get(1)).getChildren().get(3)).getChildren().get(0))).getChildren().get(1));
        long secondPostPlusCount = posts.get(1).getPlusCount();

        //when
        clickOn(secondAddButton);

        // then:
        assert secondPostPlusCount == posts.get(1).getPlusCount() + 1L;
        assert (!secondAddButton.isVisible());
        assert (!secondMinusButton.isVisible());
    }

    @Test
    public void invisibleEdit(){
        // given
        Button secondEditButton = (Button) ((((VBox)((HBox)vBox.getChildren().get(1)).getChildren().get(3)).getChildren().get(1)));
        Button firstEditButton = (Button) ((((VBox)((HBox)vBox.getChildren().get(0)).getChildren().get(3)).getChildren().get(1)));

        //when

        // then:
        assert (!secondEditButton.isVisible());
        assert (firstEditButton.isVisible());
    }



}