package com.fls.forum.model;

import java.util.Date;

public class AnswerPost extends Post{

    private boolean rightAnswer;

    public AnswerPost(long topicId, long id, Date cratedAt, long userId, Content content) {
        super(topicId, id, cratedAt, userId, content);
        rightAnswer = false;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
