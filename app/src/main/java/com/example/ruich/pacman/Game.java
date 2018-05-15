package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game {
    static final int BEANSROW = 5;
    static final int BEANSCOL = 5;
    static final float SCALEYUP = 1.0f - (1.0f - BEANSROW * (1.0f / (BEANSCOL+1))/2.0f);
    static final float SCALEYDOWN = 1.0f - BEANSROW * (1.0f / (BEANSCOL+1))/2;

    private Enemies enemies;
    private Pac pac;
    private Beans beans;

    private boolean eaten;

    public Game(){
        this.pac = new Pac();

    }

    public void touch(float xpos, float ypos) {
    }

    public void draw(Canvas canvas, Paint paint) {
    }

    public void step() {
    }

    public boolean hasWon() {
        return false;
    }

    public boolean shipHit() {
        return false;
    }
}
