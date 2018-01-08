package com.fls.forum.model;

import com.fls.forum.ForumApp;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;


public abstract class Post {

    private LongProperty topicId;
    private LongProperty id;
    private ObjectProperty<Date> cratedAt;
    private LongProperty authorId;
    private ObjectProperty<Content> content;
    private LongProperty plusCount;
    private ListProperty<Long> plusAuthors;
    private BooleanProperty authorPlus;

    Post(long topicId, long id, Date cratedAt, long authorId, Content content, Boolean authorPlus) {
        this.topicId = new SimpleLongProperty(topicId);
        this.id = new SimpleLongProperty(id);
        this.cratedAt = new SimpleObjectProperty<>(cratedAt);
        this.authorId = new SimpleLongProperty(authorId);
        this.content = new SimpleObjectProperty<>(content);
        this.plusCount = new SimpleLongProperty(0);
        ObservableList<Long> observableList = FXCollections.observableArrayList(new ArrayList<>());
        this.plusAuthors = new SimpleListProperty<>(observableList);
        this.authorPlus = new SimpleBooleanProperty(authorPlus);
    }

    public Long getPlusCount() {
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
        plusAuthors.get().add(ForumApp.getUserId());
        setAuthorPlus(true);
    }

    public void removePlus() {
        this.plusCount.set(plusCount.get() - 1);
        plusAuthors.get().add(ForumApp.getUserId());
        setAuthorPlus(true);
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

    public Long getAuthorId() {
        return authorId.get();
    }

    public LongProperty authorIdProperty() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId.set(authorId);
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

    public Long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public Long getTopicId() {
        return topicId.get();
    }

    public LongProperty topicIdProperty() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId.set(topicId);
    }

    public ObservableList<Long> getPlusAuthors() {
        return plusAuthors.get();
    }

    public ListProperty<Long> plusAuthorsProperty() {
        return plusAuthors;
    }

    public void setPlusAuthors(ObservableList<Long> plusAuthors) {
        this.plusAuthors.set(plusAuthors);
    }

    public boolean isAuthorPlus() {
        return authorPlus.get();
    }

    public BooleanProperty authorPlusProperty() {
        return authorPlus;
    }

    public void setAuthorPlus(boolean authorPlus) {
        this.authorPlus.set(authorPlus);
    }
}

