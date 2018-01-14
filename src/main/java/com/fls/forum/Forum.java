package com.fls.forum;

import com.fls.forum.controller.ForumController;
import com.fls.manager.Manager;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Marcin on 2017-12-12.
 */
public class Forum {

    private ForumController forumController = new ForumController();

    public Pane load() {
        return forumController.loadSectionsPane();
    }

    public void setManager(Manager manager){
        forumController.setManager(manager);
    }
}