package com.fls.forum.controller;

import com.fls.forum.model.localModel.*;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

    private ForumController forumController;

    private TimedLabel errorTimedLabel;

    private int itemsOnPage = 5;


    @FXML
    private void handleSendAction() {
        if(answerText.getText().length() > 0) {
            Post post = new AnswerPost(topic, 1, new Date(), userId, new Content(1, answerText.getText()), false);
            addPost(post);
            post.sendToServer(forumController.getServerController());
            answerText.setText("");
        }
        else{
            errorTimedLabel.setText("You cannot send empty message", 3);
        }
    }


    @FXML
    private void initialize() {

        mainVbox.prefWidthProperty().bind(mainPane.widthProperty());
        mainVbox.prefHeightProperty().bind(mainPane.heightProperty());


        scrollPane.prefWidthProperty().bind(mainVbox.widthProperty().multiply(0.9));
        scrollPane.prefHeightProperty().bind(mainVbox.heightProperty().multiply(0.7));

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        pagination.prefWidthProperty().bind(scrollPane.widthProperty());
        pagination.prefHeightProperty().bind(scrollPane.heightProperty());

        this.errorTimedLabel = new TimedLabel(errorLabel);

        pagination.setPageFactory(this::createPage);

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


    void setForumController(ForumController forumController){
        this.forumController = forumController;
    }


    private void addPost(Post post){
        if(posts.size() % itemsOnPage != 0 && pagination.getPageCount() - 1 == pagination.getCurrentPageIndex()) {
            hBoxList.add(postView.showPost(post));
        }
        posts.add(post);

        if(posts.size() % itemsOnPage ==  1)
            pagination.setPageCount(pagination.getPageCount() + 1);
        pagination.setCurrentPageIndex(pagination.getPageCount() - 1);
    }

    private void viewPost(Post post){
        if(posts.size() % itemsOnPage != 0 && pagination.getPageCount() - 1 == pagination.getCurrentPageIndex()) {
            hBoxList.add(postView.showPost(post));
        }
        pagination.setCurrentPageIndex(pagination.getPageCount() - 1);
    }

    void setData(Long userId, Topic topic) {
        this.userId = userId;
        this.topic = topic;
        postView = new PostView(forumController);
        posts = topic.getPosts();
        for(Post post: posts){
            viewPost(post);
        }
        pagination.setCurrentPageIndex(0);

        titleLabel.setText(topic.getQuestionPost().getTitle());
        pagination.setPageCount((posts.size() - 1) / itemsOnPage + 1);
    }

    public ObservableList<Post> getPosts() {
        return posts;
    }


    public void handleGoBackAction(ActionEvent actionEvent) {
        forumController.loadTopicsPane(topic.getSection());
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
