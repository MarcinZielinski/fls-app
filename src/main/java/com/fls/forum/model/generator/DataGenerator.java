package com.fls.forum.model.generator;

import com.fls.forum.model.AnswerPost;
import com.fls.forum.model.Content;
import com.fls.forum.model.Post;
import com.fls.forum.model.QuestionPost;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;

public class DataGenerator {

    public static ObservableList<Post> generatePosts(){
        ObservableList<Post> posts = FXCollections.observableArrayList();
        posts.add(new QuestionPost(1, 1, new Date(), 1, new Content(1, "hello"), "some topic name"));
        posts.add(new AnswerPost(1, 2, new Date(), 2, new Content(2, "hello2")));
        posts.add(new AnswerPost(1, 3, new Date(), 2, new Content(3, "hello3")));
        return posts;
    }

}
