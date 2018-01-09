package com.fls.forum.controller;

import com.fls.forum.model.Post;
import com.fls.forum.model.generator.DataGenerator;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ModelTest {

    private List<Post> postList = new ArrayList<>();
    private Post post;

    @Before
    public void before(){
        postList = DataGenerator.generatePosts(null);
        post = postList.get(0);
    }

    @Test
    public void addPlusTest() {

        long plusCount = post.getPlusCount();
        post.addPlus();

        assertEquals(plusCount + 1, (long)post.getPlusCount());
    }



    @Test
    public void addMinusTest(){

        long plusCount = post.getPlusCount();

        post.removePlus();
        assertEquals(plusCount - 1, (long)post.getPlusCount());
    }
}
