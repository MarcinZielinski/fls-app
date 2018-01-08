package com.fls.manager;

public class BoundedStack<T, E> {
    private StackNode<T, E> bottom;
    private StackNode<T, E> top;
    private final int MAX_SIZE;
    private int actualSize;

    public BoundedStack(final int maxSize) {
        this.MAX_SIZE = maxSize;
        bottom = new StackNode<>(null, null); // guard
        bottom.prev = null;
        top = bottom;
    }

    public int size() {
        return actualSize;
    }

    public void push(StackNode<T, E> node) {
        if(node != null)
            push(node.firstValue, node.secondValue);
    }

    public void push(T firstValue, E secondValue) {
        if(actualSize < MAX_SIZE) {
            StackNode<T, E> next = new StackNode<>(firstValue, secondValue);

            top.next = next;
            next.prev = top;

            top = next;
            ++actualSize;
        }
    }

    public void clear() {
        top = bottom;
        actualSize = 0;
    }

    @SuppressWarnings({"Duplicates", "unchecked"}) // it's not duplicate. Using different class fields in both methods
    public StackNode<T, E> popFromTop() {
        if(isEmpty()) return null;

        StackNode<T, E> tmp = top;
        top = tmp.prev;
        top.next = null;

        --actualSize;

        return tmp;
    }

    @SuppressWarnings({"Duplicates", "unchecked"}) // it's not duplicate.. using different fields
    public StackNode<T, E> popFromBottom() {
        if(isEmpty()) return null;

        StackNode<T, E> tmp = bottom;
        bottom = tmp.next;
        bottom.prev = null;

        --actualSize;

        return tmp;
    }

    public boolean isEmpty() {
        return top == bottom;
    }

    public StackNode<T, E> peekTop() {
        return isEmpty() ? null : top;
    }
}
