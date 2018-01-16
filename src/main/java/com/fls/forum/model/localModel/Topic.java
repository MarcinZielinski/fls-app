package com.fls.forum.model.localModel;

import com.fls.forum.model.ServerController;
import com.fls.forum.model.serverModel.PostServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Set;

public class Topic {

    private long categoryId;
    private long id = 0;
    private String name;
    private QuestionPost questionPost;
    private Section section;
    private ObservableList<Post> posts = FXCollections.observableArrayList();


    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    private Long authorId = -1L;

    public List<Integer> getAllPostsIds(){
        return null;
    }

    public Topic(long categoryId, String name, QuestionPost questionPost, Section section){
        this.categoryId = categoryId;
        this.name = name;
        this.questionPost = questionPost;
        this.section = section;
        if(questionPost != null){
            addPost(questionPost);
        }

    }

    public void sendToServer(ServerController serverController){
        serverController.sendNewTopic(this);
    }


    public Topic(long categoryId, String name, QuestionPost questionPost){
        this(categoryId, name, questionPost, null);
    }

    public void loadPosts(ServerController serverController){
        this.posts.clear();
        this.posts.addAll(serverController.getAllPosts(this));
    }


    public ObservableList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post){
        posts.add(post);
    }


    public void setPosts(ObservableList<Post> posts){
        this.posts = posts;
    }


    public long getCategoryId() {
        return categoryId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public QuestionPost getQuestionPost() {
        return questionPost;
    }

    @Override
    public String toString(){
        return String.format("%s", name);
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setQuestionPost(QuestionPost questionPost) {
        this.questionPost = questionPost;
        posts.add(questionPost);
    }
}
