package com.fls.forum.model.serverModel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@XmlRootElement
public class TopicServer {
    private Integer id;
    private Integer categoryId;
    private Integer postCount;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }


    public TopicServer(Integer id, Integer categoryId, Integer postCount) {
        this.id = id;
        this.categoryId = categoryId;
        this.postCount = postCount;
    }

    public TopicServer(){ }



    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void incresePostCount() {
        postCount++;
    }

    public void decreasePostCount() {
        postCount--;
    }

}
