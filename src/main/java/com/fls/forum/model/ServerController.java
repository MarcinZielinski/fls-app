package com.fls.forum.model;

import com.fls.forum.model.localModel.*;
import com.fls.forum.model.serverModel.PostServer;
import com.fls.forum.model.serverModel.SectionServer;
import com.fls.forum.model.serverModel.TopicServer;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class ServerController {

    private ServerObjectController<SectionServer> sectionController = new ServerObjectController<>(SectionServer.class);
    private ServerObjectController<TopicServer> topicController = new ServerObjectController<>(TopicServer.class);
    private ServerObjectController<PostServer> postController = new ServerObjectController<>(PostServer.class);
    private ServerObjectParser serverObjectParser = new ServerObjectParser();


    public List<Section> getAllSections(){

        List<Section> sections = new LinkedList<>();

        for (SectionServer section: sectionController.getItemList("categories?sectionId=1"))
            sections.add(serverObjectParser.fromSectionServer(section));

        return sections;
    }

    public List<Topic> getAllTopics(Section section){

        List<Topic> topics = new LinkedList<>();

        for (TopicServer topic: topicController.getItemList("topics?categoryId=" + Long.toString(section.getId())))
            topics.add(serverObjectParser.fromTopicServer(topic, section));

        return topics;
    }

    public List<Post> getAllPosts(Topic topic){

        List<Post> posts = new LinkedList<>();

        QuestionPost questionPost = new QuestionPost(topic, new Date(), topic.getAuthorId(), new Content(topic.getName()), topic.getName());
        topic.setQuestionPost(questionPost);
        for (PostServer post: postController.getItemList("posts?topicId=" + Long.toString(topic.getId()))) {
            posts.add(serverObjectParser.fromAnswerServer(post, topic));
        }

        return posts;
    }



}
