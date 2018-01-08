package com.fls.forum;

import com.fls.forum.controller.TopicsPaneController;
import com.fls.forum.model.Section;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class TopicsPaneTest extends ApplicationTest {

    TopicsPaneController topicsPaneController;

    @Override
    public void start(Stage primaryStage) throws IOException {

        topicsPaneController = new TopicsPaneController(new Section(1,"Java", "Programowanie w języku Java"));
        FXMLLoader loader = new FXMLLoader(ForumApp.class.getResource("pane_topics.fxml"));
        loader.setController(topicsPaneController);

        Pane root;
        root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Test
    public void loadSectionName(){
        verifyThat("#sectionNameLabel", hasText("Java"));
    }

    @Test
    public void clickBackButton(){
        clickOn("#backButton");
        clickOn("#sectionsListView");
    }

    @Test
    public void paginationIndexes(){
        assertEquals(topicsPaneController.topicsListPagination.getCurrentPageIndex(), 0);
        assertEquals(topicsPaneController.topicsListPagination.getPageCount(), 3);
    }
}
