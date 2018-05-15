package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class Game {
    static final int BEANSROW = 5;
    static final int BEANSCOL = 5;
    static final float STEP = 0.1666667f;
    static final float SCALEYUP = 1.0f - (1.0f - BEANSROW * (1.0f / (BEANSCOL+1))/2.0f);
    static final float SCALEYDOWN = 1.0f - BEANSROW * (1.0f / (BEANSCOL+1))/2;
    static final int NUMBEROFENEMIES = 2;

    private Enemies enemies;
    private Pac pac;
    private Beans beans;
    private Pos estart = new Pos(0.167f, 0.083f);

    private boolean eaten;

    public Game(){
        this.pac = new Pac();
        this.beans = Beans.gridBeans(BEANSCOL, BEANSROW);
        this.enemies = new Enemies();
    }

    public void draw(Canvas canvas, Paint paint) {

        beans.draw(canvas, paint);
        enemies.draw(canvas, paint);
        pac.draw(canvas, paint);
    }

    public void step() {
        if (enemies.size() < NUMBEROFENEMIES)
            enemies.add(new Enemy(estart));
        enemies.step();
        beans.removeHit(enemies);
        beans.removeHitP(pac);
        Log.w(TAG, beans.size()+"");
        for (Enemy e : enemies) {
            if (pac.hitby(e)) eaten = true;
        }
    }

    public boolean hasWon() {
        return !eaten && beans.size() == 0;
    }

    public boolean eaten() {
        return eaten;
    }

    public void touch(float xpos, float ypos) {
        if (xpos > 0.7f && pac.pos.x + STEP < 1.0f){
            pac.pos.x += STEP;
        }
        if(xpos < 0.5f && pac.pos.x - STEP > 0.16f){
            pac.pos.x -= STEP;
        }
        if (ypos > 0.5f && pac.pos.y + STEP < SCALEYUP){
            pac.pos.y += STEP;
        }
        if (ypos < 0.5f && pac.pos.y - STEP > SCALEYDOWN)
            pac.pos.y -= STEP;

}
        }