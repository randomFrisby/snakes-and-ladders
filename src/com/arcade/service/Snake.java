package com.arcade.service;

public class Snake implements BoardElement {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public int getPosition() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
