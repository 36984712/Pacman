package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class Bean extends Sprite {
    public static final float BEANRADIUS = (1.0f / 36.0f);

    public Bean(float x, float y) {
        this.pos = new Pos(x,y);
    }

    // draw the bean
    public void draw(Canvas c , Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = pos.x * w;
        float yc = pos.y * h;
        float r = w* BEANRADIUS;
        c.drawCircle(xc, yc, r, p);
    }

    // determine if the bean be eaten
    public boolean beEaten(Enemies enemies) {
        for (Sprite e : enemies) {
            if (e.pos.distance(pos) < 1.0f/36.0f) return true;
        }
        return false;
    }

    public boolean beEatenP(Pac pac) {
        if (pac.pos.distance(pos) < 1.0f/36.0f) return true;
        return false;
    }
}
