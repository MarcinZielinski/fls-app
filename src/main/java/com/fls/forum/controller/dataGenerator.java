package com.fls.forum.controller;

import com.fls.forum.model.QuestionPost;
import com.fls.forum.model.Section;
import com.fls.forum.model.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataGenerator {

    private List<Section> sections;
    private List<Topic> topics;

    public dataGenerator(){
        sections = new ArrayList<>();
        topics = new ArrayList<>();
        fillWithSections();
        fillWithTopics();
    }

    private void fillWithSections(){
        sections.add(new Section(1, "Java", "Programowanie w języku Java"));
        sections.add(new Section(2, "Humor", "Napisz coś śmiesznego"));
        sections.add(new Section(3, "Koło", "BIT, AGLO, AI i inne"));
        sections.add(new Section(4, "Praktyki", "Ogłoszenia pracy, staże"));
    }

    private void fillWithTopics(){
        topics.add(new Topic(1, 100, "What is a NullPointerException, and how do I fix it?", new QuestionPost()));
        topics.add(new Topic(1, 101, "Is java pass by reference or pass by value?", new QuestionPost()));
    }

    public List<Section> getSections(){
        return sections;
    }

    public List<Topic> getTopics(long sectionId){
        List<Topic> result = new ArrayList<>();
        for (Topic topic: topics){
            if(topic.getCategoryId() == sectionId){
                result.add(topic);
            }
        }
        System.out.print(result);
        return result;
    }

}
