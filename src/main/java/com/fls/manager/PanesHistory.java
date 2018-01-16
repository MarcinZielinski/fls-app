package com.fls.manager;

import javafx.beans.property.IntegerProperty;
import javafx.scene.Node;

public class PanesHistory {
    private BoundedStack<Node, Object> undoStack;
    private BoundedStack<Node, Object> redoStack;
    private IntegerProperty redoStackSize;
    private IntegerProperty undoStackSize;
    private int size;

    public PanesHistory(int size) {
        this.size = size;
        undoStack = new BoundedStack<>(size);
        redoStack = new BoundedStack<>(size);
        redoStackSize = redoStack.sizeProperty();
        undoStackSize = undoStack.sizeProperty();
    }

    public void addPane(Node pane, Object module) {
        redoStack.clear();
        if (undoStack.getSize() == size) {
            undoStack.popFromBottom();
        }
        undoStack.push(pane, module);
    }

    public StackNode<Node, Object> undoPane() {
        if (undoStack.getSize() == 1) return null;
        StackNode<Node, Object> actualNode = undoStack.popFromTop();
        StackNode<Node, Object> previousNode = undoStack.peekTop();
        redoStack.push(actualNode);
        return previousNode;
    }

    public StackNode<Node, Object> redoPane() {
        StackNode<Node, Object> nextNode = redoStack.popFromTop();
        if (nextNode != null) {
            undoStack.push(nextNode);
        }
        return nextNode;
    }

    public IntegerProperty redoStackSizeProperty() {
        return redoStackSize;
    }

    public IntegerProperty undoStackSizeProperty() {
        return undoStackSize;
    }
}
