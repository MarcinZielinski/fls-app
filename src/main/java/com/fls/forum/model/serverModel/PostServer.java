package com.fls.forum.model.serverModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PostServer {
    private Integer id;
    private Integer topicId;
    private Integer authorId;
    private String content;
    private Integer plusCount;

    public PostServer(Integer id, Integer topicId, Integer authorId, String content, Integer plusCount) {
        this.id = id;
        this.topicId = topicId;
        this.authorId = authorId;
        this.content = content;
        this.plusCount = plusCount;
    }

    public PostServer(){ }


    public Integer getTopicId() {
        return topicId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPlusCount() {
        return plusCount;
    }
}
