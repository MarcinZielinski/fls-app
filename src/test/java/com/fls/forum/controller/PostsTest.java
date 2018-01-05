package com.fls.forum.controller;

import com.fls.forum.loader.PostsLoader;
import com.fls.forum.model.Post;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;


public class PostsTest extends ApplicationTest {
    Parent sceneRoot;

    @Override public void start(Stage stage) throws IOException {
        sceneRoot = new PostsLoader().load();
        Scene scene = new Scene(sceneRoot, 100, 100);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void should_contain_button() {
        // expect:
        verifyThat(".button", hasText("Send"));
    }
}