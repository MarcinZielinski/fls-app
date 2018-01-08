package com.fls.forum;

import com.fls.forum.controller.SectionsPaneController;
import com.fls.forum.controller.TopicsPaneController;
import com.fls.forum.model.Section;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class SectionsPaneTest extends ApplicationTest {

    SectionsPaneController sectionsPaneController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("pane_sections.fxml"));

        sectionsPaneController = loader.getController();

        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void loadSectionName(){
        verifyThat("#sectionsListView", Node::hasProperties);
    }

    @Test
    public void clickBackButton(){
        clickOn("#sectionListView");
    }
}
