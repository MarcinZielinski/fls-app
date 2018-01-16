package com.fls.forum.model.localModel;

import java.util.Date;

public class AnswerPost extends Post {

    private boolean rightAnswer;

    public AnswerPost(Topic topic, long id, Date cratedAt, long userId, Content content, Boolean authorPlus) {
        super(topic, id, cratedAt, userId, content, authorPlus);
        rightAnswer = false;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
