package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

import static android.content.ContentValues.TAG;

public class Beans extends ArrayList<Bean> {

    public static Beans gridBeans(int cols, int rows) {
        Beans res = new Beans();
        float xgap = 1.0f / (cols + 1);
        for (float y = (1.0f - xgap * rows)/2; y < (1.0f - (1.0f - xgap * rows)/2); y += xgap) {
            for (float x = xgap; x < (1.0f - xgap / 2.0f); x += xgap) {
                res.add(new Bean(x, y));
            }
        }
        String l = res.get(0).pos.toString();
        Log.w(TAG, l );
        Log.w(TAG, ""+res.size() );
        return res;
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Bean a : this) a.draw(canvas, paint);
    }

    public void step() {}

    public void removeHit(Enemies enemies) {
        Iterator<Bean> bi = this.iterator();
        while (bi.hasNext()) {
            Bean b = bi.next();
            if (b.beEaten(enemies)) bi.remove();
        }
    }

    public void removeHitP(Pac pac) {
        Iterator<Bean> bi = this.iterator();
        while (bi.hasNext()) {
            Bean b = bi.next();
            if (b.beEatenP(pac)) bi.remove();
        }
    }

}
