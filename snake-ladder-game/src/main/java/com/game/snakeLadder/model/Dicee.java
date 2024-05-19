package com.game.snakeLadder.model;

public class Dicee {
    private int count;
    private int min;
    private int max;

    public Dicee(int count) {
        this.count = count;
        this.min = count;
        this.max = count*6;
    }

    public int roll(){
        int mn = this.min;
        int mx = this.max+1;
        return (int) (Math.random() * (mx - mn)) + mn;
    }
}
