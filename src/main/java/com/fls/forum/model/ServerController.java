package com.fls.forum.model;

import com.fls.forum.controller.dataGenerator;
import com.fls.forum.model.generator.DataGenerator;
import com.fls.forum.model.localModel.*;
import com.fls.forum.model.serverModel.PostServer;
import com.fls.forum.model.serverModel.SectionServer;
import com.fls.forum.model.serverModel.TopicServer;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class ServerController {

    private ServerObjectController<SectionServer> sectionController = new ServerObjectController<>(SectionServer.class);
    private ServerObjectController<TopicServer> topicController = new ServerObjectController<>(TopicServer.class);
    private ServerObjectController<PostServer> postController = new ServerObjectController<>(PostServer.class);
    private ServerObjectParser serverObjectParser = new ServerObjectParser();
    private String urlPrefix = "http://localhost:8080/";

    private boolean SERVER_COMMUNICATION;

    public ServerController(){

        try {

            URL oracle = new URL(urlPrefix + "/register");
            oracle.openConnection().getInputStream();
            SERVER_COMMUNICATION = true;
        } catch (IOException e) {
            SERVER_COMMUNICATION = false;
        }

    }



    public List<Section> getAllSections(){

        if(SERVER_COMMUNICATION) {

            List<Section> sections = new LinkedList<>();

            for (SectionServer section : sectionController.getItemList("categories?sectionId=1"))
                sections.add(serverObjectParser.fromSectionServer(section));

            return sections;
        }
        else return dataGenerator.getSections();
    }

    public List<Topic> getAllTopics(Section section){

        if(SERVER_COMMUNICATION) {

            List<Topic> topics = new LinkedList<>();

            for (TopicServer topic : topicController.getItemList("topics?categoryId=" + Long.toString(section.getId())))
                topics.add(serverObjectParser.fromTopicServer(topic, section));

            return topics;
        }
        else return dataGenerator.getTopics(section.getId());
    }

    public List<Post> getAllPosts(Topic topic){

        if(SERVER_COMMUNICATION) {
            List<Post> posts = new LinkedList<>();

            QuestionPost questionPost = new QuestionPost(topic, new Date(), topic.getAuthorId(), new Content(topic.getName()), topic.getName());
            topic.setQuestionPost(questionPost);
            for (PostServer post : postController.getItemList("posts?topicId=" + Long.toString(topic.getId()))) {
                posts.add(serverObjectParser.fromAnswerServer(post, topic));
            }

            return posts;
        }
        else return DataGenerator.generatePosts(topic);
    }



}
