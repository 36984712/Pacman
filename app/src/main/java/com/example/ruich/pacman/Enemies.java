package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Enemies extends ArrayList<Enemy> {
    public static final float BOMBSTEP = (1.0f / 6.0f);

    public void step() {
        for (Enemy e : this){
            double r = Math.random();
            r = r * 4;
            int i = (int)r;
            boolean move = false;
            Log.w(TAG, r+"");
            if (i == 0 && !move && e.pos.x + BOMBSTEP < 1.0f){
                e.pos.x += BOMBSTEP;
                move = true;
            }else if (i == 1 && !move && e.pos.x - BOMBSTEP >= 0.16f){
                e.pos.x -= BOMBSTEP;
                move = true;
            }else if (i == 2 && !move && e.pos.y + BOMBSTEP < Game.SCALEYUP){
                e.pos.y += BOMBSTEP;
                move = true;
            }else if (i == 3 && !move && e.pos.y - BOMBSTEP > Game.SCALEYDOWN){
                e.pos.y -= BOMBSTEP;
                move = true;
            }

        }
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Enemy b : this) b.draw(canvas, paint);
    }
}
