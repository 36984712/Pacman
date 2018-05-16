package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class Game {
    static final int BEANSROW = 5;
    static final int BEANSCOL = 5;
    static final float STEP = (1.0f / 6.0f);
    static final float SCALEYDOWN = (1.0f / 6.0f);
    static final float SCALEYUP = 1.0f - (1.0f / 6.0f);
    static final int NUMBEROFENEMIES = 2;

    private Enemies enemies;
    private Pac pac;
    private Beans beans;
    private Pos estart = new Pos(0.167f, 0.083f);
    private boolean moveAvailable = true;

    private boolean eaten;

    public Game(){
        this.pac = new Pac();
        this.beans = Beans.gridBeans(BEANSCOL, BEANSROW);
        this.enemies = new Enemies();
    }

    public void draw(Canvas canvas, Paint paint) {

        beans.draw(canvas, paint);

        Paint pace = new Paint();
        pace.setColor(Color.RED);
        pace.setStrokeWidth(3.0f);
        enemies.draw(canvas, pace);

        Paint pacp = new Paint();
        pacp.setColor(Color.YELLOW);
        pacp.setStrokeWidth(3.0f);
        pac.draw(canvas, pacp);
    }

    public void step() {
        moveAvailable = true;
        if (enemies.size() < NUMBEROFENEMIES)
            enemies.add(new Enemy(estart));
        //enemies.step();
        beans.removeHit(enemies);
        beans.removeHitP(pac);
        //Log.w(TAG, beans.size()+"");
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
        if (xpos > 0.5f && ypos > 0.25f && ypos < 0.75f) {
            if (pac.pos.x + STEP <= (1.0f - STEP)){
                pac.pos.x += STEP;
                moveAvailable = false;
            }
        }
        if (xpos < 0.5f && ypos > 0.25f && ypos < 0.75f) {
            if (pac.pos.x - STEP >= STEP){
                pac.pos.x -= STEP;
                moveAvailable = false;
            }
        }
        if(ypos < 0.25f){
            if (pac.pos.y - STEP > STEP){
                pac.pos.y -= STEP;
                moveAvailable = false;

            }
        }
        if (ypos > 0.75f){
            if (pac.pos.y + STEP < (1.0f - STEP)){
                pac.pos.y += STEP;
                moveAvailable = false;
            }
        }
        Log.w(TAG, "x: " + pac.pos.x + "  y: " + pac.pos.y);
    }
}