package com.fls.forum.model;

import java.util.Date;

public class QuestionPost extends Post{
    private boolean solved;
    private String title;

    public QuestionPost(long topicId, long id, Date cratedAt, long userId, Content content, String title, Boolean authorPlus) {
        super(topicId, id, cratedAt, userId, content, authorPlus);
        solved = false;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
