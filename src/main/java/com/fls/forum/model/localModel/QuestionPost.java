package com.fls.forum.model.localModel;

import java.util.Date;

public class QuestionPost extends Post {
    private boolean solved;
    private String title;

    public QuestionPost(Topic topic, long id, Date createdAt, long userId, Content content, String title, Boolean authorPlus) {
        super(topic, id, createdAt, userId, content, authorPlus);
        solved = false;
        this.title = title;
    }

    public QuestionPost(Topic topic, Date createdAt, long userId, Content content, String title) {
        super(topic, -1, createdAt, userId, content, false);
        solved = false;
        this.title = title;

    }

    public QuestionPost() {
        super(null, 1, new Date(), 1, new Content("some text"), false);
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
