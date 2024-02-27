package com.arcade.model;

import com.arcade.service.Ladder;
import com.arcade.service.Snake;

import java.util.List;

public class Board {
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(List<Snake> snakes, List<Ladder> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
