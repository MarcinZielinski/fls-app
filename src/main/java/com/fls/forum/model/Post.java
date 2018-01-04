package com.fls.forum.model;

import java.util.Date;
import java.util.List;


public abstract class Post {

    private long topicId;
    private long id;
    private Date cratedAt;
    private int userId;
    private Content content;
    private int plusCount;


    public List<Integer> getAllPlusAuthors(){
        return null;
    }
}

