package com.fls.forum.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;
import java.util.List;


public abstract class Post {

    private LongProperty topicId;
    private LongProperty id;
    private ObjectProperty<Date> cratedAt;
    private LongProperty userId;
    private ObjectProperty<Content> content;
    private LongProperty plusCount;

    Post(long topicId, long id, Date cratedAt, long userId, Content content) {
        this.topicId = new SimpleLongProperty(topicId);
        this.id = new SimpleLongProperty(id);
        this.cratedAt = new SimpleObjectProperty<>(cratedAt);
        this.userId = new SimpleLongProperty(userId);
        this.content = new SimpleObjectProperty<>(content);
        this.plusCount = new SimpleLongProperty(0);
    }


//    public List<Integer> getAllPlusAuthors(){
//        return null;
//    }

    public long getPlusCount() {
        return plusCount.get();
    }

    public LongProperty plusCountProperty() {
        return plusCount;
    }

    public void setPlusCount(long plusCount) {
        this.plusCount.set(plusCount);
    }

    public void addPlus() {
        this.plusCount.set(plusCount.get() + 1);
    }

    public void removePlus() {
        this.plusCount.set(plusCount.get() - 1);
    }

    public Content getContent() {
        return content.get();
    }

    public ObjectProperty<Content> contentProperty() {
        return content;
    }

    public void setContent(Content content) {
        this.content.set(content);
    }

    public long getUserId() {
        return userId.get();
    }

    public LongProperty userIdProperty() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId.set(userId);
    }

    public Date getCratedAt() {
        return cratedAt.get();
    }

    public ObjectProperty<Date> cratedAtProperty() {
        return cratedAt;
    }

    public void setCratedAt(Date cratedAt) {
        this.cratedAt.set(cratedAt);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public long getTopicId() {
        return topicId.get();
    }

    public LongProperty topicIdProperty() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId.set(topicId);
    }

}

