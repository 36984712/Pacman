package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

public class Beans extends ArrayList<Bean> {

    public static Beans gridAliens(int cols, int rows) {
        Beans res = new Beans();
        float xgap = 1.0f / (cols + 1);
        for (float y = (1.0f - xgap * rows)/2; y <= (1.0f - (1.0f - xgap * rows)/2); y += xgap) {
            for (float x = xgap; x < (1.0f - xgap / 2.0f); x += xgap) {
                res.add(new Bean(x, y));
            }
        }
        return res;
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Bean a : this) a.draw(canvas, paint);
    }

    public void step() {}

    public void removeHit(Enemies enemies) {
        Iterator<Bean> ai = this.iterator();
        while (ai.hasNext()) {
            Bean a = ai.next();
            if (a.beEaten(enemies)) ai.remove();
        }
    }

    public void removeHitP(Pac pac) {
        Iterator<Bean> ai = this.iterator();
        while (ai.hasNext()) {
            Bean a = ai.next();
            if (a.beEatenP(pac)) ai.remove();
        }
    }
}
