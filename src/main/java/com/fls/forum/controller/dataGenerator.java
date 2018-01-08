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


    private void fillWithSections(){
        sections.add(new Section(1, "Java", "Programowanie w języku Java"));
        sections.add(new Section(2, "Humor", "Napisz coś śmiesznego"));
        sections.add(new Section(3, "Koło", "BIT, AGLO, AI i inne"));
        sections.add(new Section(4, "Praktyki", "Ogłoszenia pracy, staże"));
    }

    private void fillWithTopics(){
        topics.add(new Topic(1, 100, "What is a NullPointerException, and how do I fix it?", new QuestionPost()));
        topics.add(new Topic(1, 101, "Is java pass by reference or pass by value?", new QuestionPost()));
        topics.add(new Topic(1, 102, "How do I compare strings in Java?", new QuestionPost()));
        topics.add(new Topic(1, 103, "The Use of Multiple JFrames: Good or Bad Practice? [closed]", new QuestionPost()));
        topics.add(new Topic(1, 104, "Unfortunately MyApp has stopped. How can I solve this?", new QuestionPost()));
        topics.add(new Topic(1, 105, "Scanner is skipping nextLine() after using next() or nextFoo()?", new QuestionPost()));
        topics.add(new Topic(1, 106, "What causes a java.lang.ArrayIndexOutOfBoundsException and how do I prevent it?", new QuestionPost()));
        topics.add(new Topic(1, 107, "How to add JTable in JPanel with null layout?", new QuestionPost()));
        topics.add(new Topic(1, 108, "Should I avoid the use of set(Preferred|Maximum|Minimum)Size methods in Java Swing?", new QuestionPost()));
        topics.add(new Topic(1, 109, "Providing white space in a Swing GUI", new QuestionPost()));
        topics.add(new Topic(1, 110, "How do I write a correct micro-benchmark in Java?", new QuestionPost()));
        topics.add(new Topic(1, 111, "How to parse JSON", new QuestionPost()));
        topics.add(new Topic(1, 112, "What is a NullPointerException, and how do I fix it?", new QuestionPost()));
        topics.add(new Topic(1, 113, "Is java pass by reference or pass by value?", new QuestionPost()));
        topics.add(new Topic(1, 114, "How do I compare strings in Java?", new QuestionPost()));
        topics.add(new Topic(1, 115, "The Use of Multiple JFrames: Good or Bad Practice? [closed]", new QuestionPost()));
        topics.add(new Topic(1, 116, "Unfortunately MyApp has stopped. How can I solve this?", new QuestionPost()));
        topics.add(new Topic(1, 117, "Scanner is skipping nextLine() after using next() or nextFoo()?", new QuestionPost()));
        topics.add(new Topic(1, 118, "What causes a java.lang.ArrayIndexOutOfBoundsException and how do I prevent it?", new QuestionPost()));
        topics.add(new Topic(1, 119, "How to add JTable in JPanel with null layout?", new QuestionPost()));
        topics.add(new Topic(1, 120, "Should I avoid the use of set(Preferred|Maximum|Minimum)Size methods in Java Swing?", new QuestionPost()));
        topics.add(new Topic(1, 121, "Providing white space in a Swing GUI", new QuestionPost()));
        topics.add(new Topic(1, 122, "How do I write a correct micro-benchmark in Java?", new QuestionPost()));
        topics.add(new Topic(1, 123, "How to parse JSON", new QuestionPost()));



    }

}
