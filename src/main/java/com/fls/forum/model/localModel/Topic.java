package com.fls.forum.model.localModel;

import com.fls.forum.model.ServerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Topic {

    private long categoryId;
    private long id = -1;
    private String name;
    private QuestionPost questionPost;
    private Section section;
    private ObservableList<Post> posts = FXCollections.observableArrayList();
    private Long authorId = -1L;

    public Topic(long categoryId, String name, QuestionPost questionPost, Section section) {
        this.categoryId = categoryId;
        this.name = name;
        this.questionPost = questionPost;
        this.section = section;
        if (questionPost != null) {
            addPost(questionPost);
        }

    }

    public Topic(long categoryId, String name, QuestionPost questionPost) {
        this(categoryId, name, questionPost, null);
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public List<Integer> getAllPostsIds() {
        return null;
    }

    public void loadPosts(ServerController serverController) {
        this.posts.clear();
        this.posts.addAll(serverController.getAllPosts(this));
    }


    public ObservableList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ObservableList<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        posts.add(post);
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

    public void setQuestionPost(QuestionPost questionPost) {
        this.questionPost = questionPost;
        posts.add(questionPost);
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
