package com.fls.forum.controller;

import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class TimedLabel {

    private Timer timer = new Timer();

    private Label label;

    TimedLabel(Label label){
        this.label = label;
    }

    void setText(String text, double seconds){
        label.setText(text);
        label.setVisible(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                label.setVisible(false);
            }
        }, (int)(seconds * 1000));
    }
}
