package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Pac extends Sprite {
    public static final float STARTX = 0.5f;
    public static final float STARTY = 0.5f;
    public static final float PACRADIUS = (1.0f / 12.0f);
    public Pac(){
        pos = new Pos(STARTX,STARTY);
    }
    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = pos.x * w;
        float yc = pos.y * h;
        float r = w* PACRADIUS;
        c.drawCircle(xc, yc, r, p);
    }

    public boolean hitby(Enemy b) {
        return (b.pos.distance(pos) < PACRADIUS);
    }
}
