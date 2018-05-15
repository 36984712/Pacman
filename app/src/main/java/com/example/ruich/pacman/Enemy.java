package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Enemy extends Sprite {
    public static final float ENEMYRADIUS = (1.0f / 20.0f);

    public Enemy(Pos p) {
        pos = new Pos(p);
    }

    // draw the enemy
    public void draw(Canvas c , Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = pos.x * w;
        float yc = pos.y * h;
        float r = w * ENEMYRADIUS;
        c.drawCircle(xc, yc, r, p);
    }
}
