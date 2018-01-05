package com.fls.util;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class ThreadHelper<T> extends Service<T> {

    private static ProgressIndicator progressIndicator = new ProgressIndicator();
    private Callable<T> method;

    public ThreadHelper(StackPane parentPane, Callable<T> method, Consumer<T> whatToDoOnSucceed) {
        if(!parentPane.getChildren().contains(progressIndicator)) {
            parentPane.getChildren().add(progressIndicator);
        }
        this.method = method;
        progressIndicator.visibleProperty().bind(this.runningProperty());
        this.setOnSucceeded(workerStateEvent -> {
            T result = this.getValue();   //here you get the return value of your service
            parentPane.getChildren().remove(progressIndicator);
            whatToDoOnSucceed.accept(result);
        });
    }

    @Override
    protected Task<T> createTask() {
        return new Task<T>() {
            @Override
            protected T call() {
                T res = null;
                try {
                    res = method.call();
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("Actual search interrupted");
                }
                return res;
            }
        };
    }
}
