package com.fls.forum.controller;

import com.fls.forum.ForumApp;
import com.fls.forum.model.*;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

import java.util.Date;

public class PostsController {



    private Long userId;
    private Topic topic;
    private PostView postView;



    private ObservableList<Post> posts = FXCollections.observableArrayList();



    @FXML
    private VBox mainVbox;

    @FXML
    private Button backButton;

    @FXML
    private  Button send;

    @FXML
    private Label errorLabel;

    @FXML
    private Pane mainPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextArea answerText;

    @FXML
    private Label titleLabel;


    @FXML
    private Pagination pagination;


    private ObservableList<Node> hBoxList = FXCollections.observableArrayList();

    private ApplicationController applicationController;

    private TimedLabel errorTimedLabel;

    private int itemsOnPage = 5;


    @FXML
    private void handleSendAction() {
        if(answerText.getText().length() > 0) {
            addPost(new AnswerPost(topic, 1, new Date(), userId, new Content(1, answerText.getText()), false));
            answerText.setText("");
        }
        else{
            errorTimedLabel.setText("You cannot send empty message", 3);
        }
    }


    @FXML
    private void initialize() {
//        vBox.prefWidthProperty().bind(scrollPane.widthProperty());
//        vBox.prefHeightProperty().bind(scrollPane.heightProperty());

        mainVbox.prefWidthProperty().bind(mainPane.widthProperty());
        mainVbox.prefHeightProperty().bind(mainPane.heightProperty());


        scrollPane.prefWidthProperty().bind(mainVbox.widthProperty().multiply(0.9));
        scrollPane.prefHeightProperty().bind(mainVbox.heightProperty().multiply(0.7));

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        pagination.prefWidthProperty().bind(scrollPane.widthProperty());
        pagination.prefHeightProperty().bind(scrollPane.heightProperty());


        this.errorTimedLabel = new TimedLabel(errorLabel);


//        pagination.setStyle("-fx-border-color:red;");
        pagination.setPageFactory(this::createPage);

        IntegerBinding sizeProperty = Bindings.size(posts);

        pagination.pageCountProperty().bind(sizeProperty.add(itemsOnPage - 1).divide(itemsOnPage));

    }

    private VBox createPage(int pageIndex){
        VBox box = new VBox();
        int page = pageIndex * itemsOnPage;
        hBoxList = FXCollections.observableArrayList();
        hBoxList.clear();
        for (int i = page; i < page + itemsOnPage && i < posts.size(); i++) {
            HBox hBox = postView.showPost(posts.get(i));
            hBoxList.add(hBox);
        }

        Bindings.bindContentBidirectional(box.getChildren(), hBoxList);
        return box;
    }


    void setApplicationController(ApplicationController applicationController){
        this.applicationController = applicationController;
    }


    private void addPost(Post post){
        if(posts.size() % itemsOnPage != 0 && pagination.getPageCount() - 1 == pagination.getCurrentPageIndex()) {
            System.out.println("adding post");
            hBoxList.add(postView.showPost(post));
        }
        posts.add(post);
        pagination.setCurrentPageIndex(pagination.getPageCount() - 1);
    }

    void setData(Long userId, Topic topic, ObservableList<Post> posts) {
        this.userId = userId;
        this.topic = topic;
//        postView = new PostView(vBox, applicationController);
        postView = new PostView(applicationController);
        for(Post post: posts) {
            addPost(post);
        }
        pagination.setCurrentPageIndex(0);

        titleLabel.setText(((QuestionPost)posts.get(0)).getTitle());
    }

    public ObservableList<Post> getPosts() {
        return posts;
    }


    public void handleGoBackAction(ActionEvent actionEvent) {
        applicationController.loadTopicsPane(topic.getSection());
    }

    public VBox getMainVbox() {
        return mainVbox;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public ObservableList<Node> gethBoxList() {
        return hBoxList;
    }

}
