package com.game.snakeLadder.model;

public class Player {
    String name;
    int currentCell;

    public Player(String name, int currentCell) {
        this.name = name;
        this.currentCell = currentCell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(int currentCell) {
        this.currentCell = currentCell;
    }
}
