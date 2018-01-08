package com.fls.manager;

import javafx.scene.Node;

public class PanesHistory {
    private BoundedStack<Node, Object> undoStack;
    private BoundedStack<Node, Object> redoStack;
    private int size;

    public PanesHistory(int size) {
        this.size = size;
        undoStack = new BoundedStack<>(size);
        redoStack = new BoundedStack<>(size);
    }

    public void addPane(Node pane, Object module) {
        redoStack.clear();
        if(undoStack.size() == size) {
            undoStack.popFromBottom();
        }
        undoStack.push(pane,module);
    }

    public StackNode<Node, Object> undoPane() {
        if(undoStack.size() == 1) return null;
        StackNode <Node, Object> actualNode = undoStack.popFromTop();
        StackNode<Node, Object> previousNode = undoStack.peekTop();
        redoStack.push(actualNode);
        return previousNode;
    }

    public StackNode<Node, Object> redoPane() {
        StackNode<Node, Object> nextNode = redoStack.popFromTop();
        if(nextNode != null) {
            undoStack.push(nextNode);
        }
        return nextNode;
    }
}
