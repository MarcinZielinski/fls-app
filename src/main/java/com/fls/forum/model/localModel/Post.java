package com.fls.forum.model.localModel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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

    public LongProperty plusCountProperty() {
        return plusCount;
    }

    public void setPlusCount(long plusCount) {
        this.plusCount.set(plusCount);
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}

