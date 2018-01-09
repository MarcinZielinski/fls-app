package com.fls.forum.controller;

import com.fls.forum.model.AnswerPost;
import com.fls.forum.model.Post;
import com.fls.forum.model.QuestionPost;
import com.fls.forum.model.Section;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Date;
import java.util.Random;


public class TopicsCreatorPaneController {

    private Section section;
    private Stage stage;

    @FXML
    private Label currentSectionNameLabel;

    @FXML
    private Label topicNameErrorLabel;

    @FXML
    private TextArea topicQuestionContentTextArea;

    @FXML
    private TextField topicNameTextField;

    public void setData(Section section, Stage stage){
        this.section = section;
        this.stage = stage;
        currentSectionNameLabel.setText(section.getName());
        addTextLimiter(topicNameTextField, 100);
    }

    private void onBackFromTopicCreatorButtonClicked(){
        stage.close();
    }

    private boolean validateCreatedTopic(String postContent, String topicName){
        if(topicName.length() > 3) {

            if (postContent.length() > 15000) {
                topicNameErrorLabel.setText(String.format("Zbyt duża ilość znaków: %d (max. 15000)", postContent.length()));
                topicNameErrorLabel.setVisible(true);
                return false;
            }
        } else {
            topicNameErrorLabel.setText("Nazwa tematu powinna być dłuższa niż 3 znaki");
            topicNameErrorLabel.setVisible(true);
            return false;
        }


        topicNameErrorLabel.setVisible(false);
        return true;
    }

    public void onMakePostButtonClicked(){
        String topicName = topicNameTextField.getText();
        String postContent = topicQuestionContentTextArea.getText();

        if(validateCreatedTopic(postContent, topicName)){
            //TODO: create QuestionPost

            //TODO: create Topic
        }
    }

    //TODO: validation if no posts or no content

    private static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener((ov, oldValue, newValue) -> {
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            }
        });
    }


}
