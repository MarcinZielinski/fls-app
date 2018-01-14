package com.fls.forum.controller;

import com.fls.forum.model.Section;
import com.fls.forum.model.Topic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TopicsPaneController implements Initializable{

    private Section currentSection;
    @FXML
    private ListView<Topic> topicsListView = new ListView<>();
    private ObservableList<Topic> nameList;
    private List<Topic> topics = new ArrayList<>();
    private ForumController forumController;

    @FXML
    private Label sectionNameLabel;

    @FXML
    private Pagination topicsListPagination;


//    public TopicsPaneController(Section section){
//        this.currentSection = section;
//    }

    private int topicsPerPage(){
        return 10;
    }

    private ListView<Topic> createPage(int pageIndex) {
        int start = pageIndex * topicsPerPage();
        topicsListView.setItems(FXCollections.observableArrayList(topics.subList(start,start+topicsPerPage() > topics.size() ? topics.size() : (start + topicsPerPage()) )));
        return topicsListView;
    }


    private void setTopicsListView(){
        if(currentSection != null){
            sectionNameLabel.setText(currentSection.getName());
        }

        topicsListPagination.setPageCount(((int)(Math.ceil((topics.size()-1) / 10)+1)));

        topicsListPagination.setPageFactory(this::createPage);

        nameList = FXCollections.observableArrayList(topics);
        //topicsListView.setItems(nameList);
        topicsListView.setOnMouseClicked(mouseEvent -> {
                Topic topic = topicsListView.getSelectionModel().getSelectedItem();
                if(topic != null && mouseEvent.getClickCount() == 2)
                    forumController.loadPostsPane(topicsListView.getSelectionModel().getSelectedItem());
        });
    }

    public void changeScreenBackButtonClicked(javafx.event.ActionEvent event) {
        forumController.loadSectionsPane();
    }

    public void setForumController(ForumController forumController) {
        this.forumController = forumController;
    }

    public void createTopicButtonClicked(javafx.event.ActionEvent event){
        forumController.loadTopicsCreator(currentSection);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }

    public void setCurrentSection(Section section){
        topics = section.getTopics();
        this.currentSection = section;
    }

    public void init(){
        setTopicsListView();
    }

}
