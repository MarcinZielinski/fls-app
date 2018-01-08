package com.fls.forum.model;

import java.util.List;

public class Topic {

    private long categoryId;
    private long id;
    private String name;
    private QuestionPost questionPost;

    public List<Integer> getAllPostsIds(){
        return null;
    }

    public Topic(long categoryId, long id, String name, QuestionPost questionPost){
        this.categoryId = categoryId;
        this.id = id;
        this.name = name;
        this.questionPost = questionPost;
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
}
