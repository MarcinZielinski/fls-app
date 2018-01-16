package com.fls.forum.model.localModel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;


public abstract class Post {

    private Topic topic;
    private LongProperty id;
    private ObjectProperty<Date> cratedAt;
    private LongProperty authorId;
    private ObjectProperty<Content> content;
    private LongProperty plusCount;
    private ListProperty<Long> plusAuthors;
    private BooleanProperty authorPlus;

    Post(Topic topic, long id, Date cratedAt, long authorId, Content content, Boolean authorPlus) {
        this.topic = topic;
        this.id = new SimpleLongProperty(id);
        this.cratedAt = new SimpleObjectProperty<>(cratedAt);
        this.authorId = new SimpleLongProperty(authorId);
        this.content = new SimpleObjectProperty<>(content);
        this.plusCount = new SimpleLongProperty(0);
        ObservableList<Long> observableList = FXCollections.observableArrayList(new ArrayList<>());
        this.plusAuthors = new SimpleListProperty<>(observableList);
        this.authorPlus = new SimpleBooleanProperty(authorPlus);
    }


    public Post(Long id, String content, Long authorId, Integer plusCount) {
        this.id = new SimpleLongProperty(id);
        this.content = new SimpleObjectProperty<>(new Content(content));
        this.authorId = new SimpleLongProperty(authorId);
        this.plusCount = new SimpleLongProperty(plusCount);
    }

    public Long getPlusCount() {
        return plusCount.get();
    }

    public void setPlusCount(long plusCount) {
        this.plusCount.set(plusCount);
    }

    public LongProperty plusCountProperty() {
        return plusCount;
    }

    public void addPlus(Long author) {
        this.plusCount.set(plusCount.get() + 1);
        plusAuthors.get().add(author);
        setAuthorPlus(true);
    }

    public void removePlus(Long author) {
        this.plusCount.set(plusCount.get() - 1);
        plusAuthors.get().add(author);
        setAuthorPlus(true);
    }

    public Content getContent() {
        return content.get();
    }

    public void setContent(Content content) {
        this.content.set(content);
    }

    public ObjectProperty<Content> contentProperty() {
        return content;
    }

    public Long getAuthorId() {
        return authorId.get();
    }

    public void setAuthorId(long authorId) {
        this.authorId.set(authorId);
    }

    public LongProperty authorIdProperty() {
        return authorId;
    }

    public Date getCratedAt() {
        return cratedAt.get();
    }

    public void setCratedAt(Date cratedAt) {
        this.cratedAt.set(cratedAt);
    }

    public ObjectProperty<Date> cratedAtProperty() {
        return cratedAt;
    }

    public Long getId() {
        return id.get();
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public LongProperty idProperty() {
        return id;
    }

    public ObservableList<Long> getPlusAuthors() {
        return plusAuthors.get();
    }

    public void setPlusAuthors(ObservableList<Long> plusAuthors) {
        this.plusAuthors.set(plusAuthors);
    }

    public ListProperty<Long> plusAuthorsProperty() {
        return plusAuthors;
    }

    public boolean isAuthorPlus() {
        return authorPlus.get();
    }

    public void setAuthorPlus(boolean authorPlus) {
        this.authorPlus.set(authorPlus);
    }

    public BooleanProperty authorPlusProperty() {
        return authorPlus;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}

