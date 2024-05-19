package com.game.snakeLadder.model;

import java.util.Map;

public class Board {
    private final Map<Integer, Integer> snakeMap;
    private final Map<Integer, Integer> ladderMap;

    public Board(Map<Integer, Integer> snakeMap, Map<Integer, Integer> ladderMap) {
        this.snakeMap = snakeMap;
        this.ladderMap = ladderMap;
    }

    public Map<Integer, Integer> getSnakeMap() {
        return snakeMap;
    }

    public Map<Integer, Integer> getLadderMap() {
        return ladderMap;
    }
}
