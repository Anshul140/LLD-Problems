package com.game.snakeLadder.model;

public class GameState {
    private boolean gameOver;
    private Player[] players;
    private Player winner = null;

    public GameState(boolean gameOver, Player[] players) {
        this.gameOver = gameOver;
        this.players = players;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
