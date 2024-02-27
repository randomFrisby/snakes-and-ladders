package com.arcade.service;

public class Ladder implements BoardElement {
    private int start;
    private int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int getPosition() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}