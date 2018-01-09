package com.fls.forum.controller;

import com.fls.forum.model.Content;
import com.fls.forum.model.QuestionPost;
import com.fls.forum.model.Section;
import com.fls.forum.model.Topic;

import java.util.*;

public class dataGenerator {

    private static List<Section> sections;
    private static List<Topic> topics;

    public static void init(){
        sections = new ArrayList<>();
        topics = new ArrayList<>();
        fillWithTopics();
        fillWithSections();
        System.out.println(topics.size());
    }


    public static List<Section> getSections(){
        return sections;
    }

    public static List<Topic> getTopics(long sectionId){

        System.out.println(topics.size());

        List<Topic> result = new ArrayList<>();
        for (Topic topic: topics){
            if(topic.getCategoryId() == sectionId){
                result.add(topic);
            }
        }


        System.out.println(result.size());

        return result;
    }


    private static void fillWithSections(){
        sections.add(new Section(1, "Java", "Programowanie w języku Java"));
        sections.add(new Section(2, "Humor", "Napisz coś śmiesznego"));
        sections.add(new Section(3, "Koło", "BIT, AGLO, AI i inne"));
        sections.add(new Section(4, "Praktyki", "Ogłoszenia pracy, staże"));
    }

    private static void fillWithTopics(){
        topics.add(new Topic(1, "What is a NullPointerException, and how do I fix it?", new QuestionPost()));
        topics.add(new Topic(1,  "Is java pass by reference or pass by value?", new QuestionPost()));
        topics.add(new Topic(1,  "How do I compare strings in Java?", new QuestionPost()));
        topics.add(new Topic(1,  "The Use of Multiple JFrames: Good or Bad Practice? [closed]", new QuestionPost()));
        topics.add(new Topic(1,  "Unfortunately MyApp has stopped. How can I solve this?", new QuestionPost()));
        topics.add(new Topic(1,  "Scanner is skipping nextLine() after using next() or nextFoo()?", new QuestionPost()));
        topics.add(new Topic(1,  "What causes a java.lang.ArrayIndexOutOfBoundsException and how do I prevent it?", new QuestionPost()));
        topics.add(new Topic(1,  "How to add JTable in JPanel with null layout?", new QuestionPost()));
        topics.add(new Topic(1,  "Should I avoid the use of set(Preferred|Maximum|Minimum)Size methods in Java Swing?", new QuestionPost()));
        topics.add(new Topic(1,  "Providing white space in a Swing GUI", new QuestionPost()));
        topics.add(new Topic(1,  "How do I write a correct micro-benchmark in Java?", new QuestionPost()));
        topics.add(new Topic(1,  "How to parse JSON", new QuestionPost()));
        topics.add(new Topic(1,  "What is a NullPointerException, and how do I fix it?", new QuestionPost()));
        topics.add(new Topic(1,  "Is java pass by reference or pass by value?", new QuestionPost()));
        topics.add(new Topic(1,  "How do I compare strings in Java?", new QuestionPost()));
        topics.add(new Topic(1,  "The Use of Multiple JFrames: Good or Bad Practice? [closed]", new QuestionPost()));
        topics.add(new Topic(1,  "Unfortunately MyApp has stopped. How can I solve this?", new QuestionPost()));
        topics.add(new Topic(1,  "Scanner is skipping nextLine() after using next() or nextFoo()?", new QuestionPost()));
        topics.add(new Topic(1,  "What causes a java.lang.ArrayIndexOutOfBoundsException and how do I prevent it?", new QuestionPost()));
        topics.add(new Topic(1,  "How to add JTable in JPanel with null layout?", new QuestionPost()));
        topics.add(new Topic(1,  "Should I avoid the use of set(Preferred|Maximum|Minimum)Size methods in Java Swing?", new QuestionPost()));
        topics.add(new Topic(1,  "Providing white space in a Swing GUI", new QuestionPost()));
        topics.add(new Topic(1,  "How do I write a correct micro-benchmark in Java?", new QuestionPost()));
        topics.add(new Topic(1,  "How to parse JSON", new QuestionPost()));

        for(Topic topic: topics){
            topic.getQuestionPost().setTopic(topic);
            topic.getQuestionPost().setSolved(false);
            topic.getQuestionPost().setTitle(topic.getName());
            topic.getQuestionPost().setContent(new Content("aaa"));
            topic.getQuestionPost().setAuthorPlus(false);
            topic.getQuestionPost().setCratedAt(new Date());
            topic.getQuestionPost().setAuthorId(1);


            topic.getQuestionPost().setTopic(topic);
        }


    }

}
