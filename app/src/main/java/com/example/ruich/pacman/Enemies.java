package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

public class Enemies extends ArrayList<Enemy> {
    public static final float BOMBSTEP = (1.0f / 6.0f);

    public void step() {
        for (Enemy e : this){
            double r1 = Math.random();
            r1 = (int)(r1 * 2 - 1);
            if (e.pos.x + r1 *BOMBSTEP > 0.0f && e.pos.x + r1 *BOMBSTEP < 1.0f){
                e.pos.x += r1 *BOMBSTEP;
            }
            double r2 = Math.random();
            r2 = (int)(r2 * 2 - 1);
            if (e.pos.y + r2 *BOMBSTEP > Game.SCALEYDOWN && e.pos.y + r2 *BOMBSTEP < Game.SCALEYUP){
                e.pos.y += r2 *BOMBSTEP;
            }
        }
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Enemy b : this) b.draw(canvas, paint);
    }
}
