package com.fls.forum.model.localModel;

public class Content {
    private long postId;
    private long id;
    private String text;


    public Content(long postId, String text) {
        this.postId = postId;
        this.text = text;
    }

    public Content(String text) {
        this.postId = -1;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
