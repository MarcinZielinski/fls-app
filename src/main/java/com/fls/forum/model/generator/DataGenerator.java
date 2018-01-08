package com.fls.forum.model.generator;

import com.fls.forum.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;

public class DataGenerator {

    public static ObservableList<Post> generatePosts(Topic topic){
        ObservableList<Post> posts = FXCollections.observableArrayList();
        posts.add(new QuestionPost(topic, 1, new Date(), 1, new Content(1, "hello"), "some topic name", false));
        posts.add(new AnswerPost(topic, 2, new Date(), 2, new Content(2, "hello2"), false));
        posts.add(new AnswerPost(topic, 3, new Date(), 2, new Content(3, "hello3"), true));
        return posts;
    }

}
