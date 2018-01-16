package com.fls.forum.model;

import com.fls.forum.model.localModel.*;
import com.fls.forum.model.serverModel.PostServer;
import com.fls.forum.model.serverModel.SectionServer;
import com.fls.forum.model.serverModel.TopicServer;

import java.util.Date;

import static java.lang.Math.toIntExact;

public class ServerObjectParser {

    public SectionServer toSectionServer(Section section) {
        return new SectionServer((int) section.getId(), 1, toIntExact(section.getTopicCount()), section.getName(),
                section.getDescription(), section.getTopicIds());
    }


    public Section fromSectionServer(SectionServer section) {
        return new Section(section.getId(), section.getName(), section.getDecription(), section.getTopics(), (long) section.getTopicCount());
    }


    public Topic fromTopicServer(TopicServer topic, Section section) {
        return new Topic(topic.getCategoryId(), "topic with id: " + topic.getId(), null, section);
    }


    public TopicServer toTopicServer(Topic topic) {
        return new TopicServer(toIntExact(topic.getId()), toIntExact(topic.getCategoryId()), topic.getPosts().size());
    }


    public QuestionPost fromQuestionServer(PostServer question, Topic topic) {
        return new QuestionPost(topic, new Date(), question.getAuthorId(), new Content(question.getContent()), topic.getName());

    }

    public AnswerPost fromAnswerServer(PostServer answer, Topic topic) {

        String content = answer.getContent() == null ? "empty content" : answer.getContent();
        Integer authorId = answer.getAuthorId() == null ? -1 : answer.getAuthorId();
        return new AnswerPost(topic, (long) answer.getId(), new Date(), (long) authorId, new Content(content), false);
    }

    public PostServer toPostServer(Post post) {
        return new PostServer(toIntExact(post.getId()), toIntExact(post.getTopic().getId()), toIntExact(post.getAuthorId()), post.getContent().toString(), toIntExact(post.getPlusCount()));
    }


}
