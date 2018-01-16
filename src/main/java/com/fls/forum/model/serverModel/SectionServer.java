package com.fls.forum.model.serverModel;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;


@XmlRootElement
public class SectionServer implements Serializable {
    private Integer id;
    private Integer sectionId;
    private Integer topicCount;
    private String name;
    private String decription;
    private List<Integer> topics;

    public SectionServer(){}

    public SectionServer(int id, int sectionId, int topicCount, String name, String description, List<Integer> topics) {
        this.id=id;
        this.sectionId=sectionId;
        this.topicCount =topicCount;
        this.name=name;
        this.decription=description;
        this.topics=topics;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(Integer topicCount) {
        this.topicCount = topicCount;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public void setTopics(List<Integer> topics) {
        this.topics = topics;
    }

    public List<Integer> getTopics() {
        return topics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }


    public void decreaseTopicCount() {
        topicCount--;
    }

    public void increaseTopicCount() {
        topicCount++;
    }

}
