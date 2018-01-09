package com.fls.manager;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BoundedStack<T, E> {
    private StackNode<T, E> bottom;
    private StackNode<T, E> top;
    private final int MAX_SIZE;
    private IntegerProperty size;

    public BoundedStack(final int maxSize) {
        this.MAX_SIZE = maxSize;
        bottom = new StackNode<>(null, null); // guard
        bottom.prev = null;
        top = bottom;
        size = new SimpleIntegerProperty(this, "size", 0);
    }

    public IntegerProperty sizeProperty() {
        return size;
    }

    public int getSize() {
        return size.get();
    }

    private void setSize(Integer size) {
        this.size.set(size);
    }

    public void push(StackNode<T, E> node) {
        if(node != null)
            push(node.firstValue, node.secondValue);
    }

    public void push(T firstValue, E secondValue) {
        if(getSize() < MAX_SIZE) {
            StackNode<T, E> next = new StackNode<>(firstValue, secondValue);

            top.next = next;
            next.prev = top;

            top = next;
            setSize(getSize()+1);
        }
    }

    public void clear() {
        top = bottom;
        setSize(0);
    }

    @SuppressWarnings({"Duplicates", "unchecked"}) // it's not duplicate. Using different class fields in both methods
    public StackNode<T, E> popFromTop() {
        if(isEmpty()) return null;

        StackNode<T, E> tmp = top;
        top = tmp.prev;
        top.next = null;

        setSize(getSize()-1);

        return tmp;
    }

    @SuppressWarnings({"Duplicates", "unchecked"}) // it's not duplicate.. using different fields
    public StackNode<T, E> popFromBottom() {
        if(isEmpty()) return null;

        StackNode<T, E> tmp = bottom;
        bottom = tmp.next;
        bottom.prev = null;

        setSize(getSize()-1);

        return tmp;
    }

    public boolean isEmpty() {
        return top == bottom;
    }

    public StackNode<T, E> peekTop() {
        return isEmpty() ? null : top;
    }
}
