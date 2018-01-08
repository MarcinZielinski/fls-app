package com.fls.manager;

public class StackNode<T, E> {
    StackNode next;
    StackNode prev;
    T firstValue;
    E secondValue;

    public StackNode(T firstValue, E secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
}
