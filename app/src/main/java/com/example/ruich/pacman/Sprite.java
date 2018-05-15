
package com.example.ruich.pacman;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Sprite - a single drawable item located at a particular position in the game area
 * Eric McCreath 11/03/16.
 */
public abstract class Sprite {
    Pos pos;

    public abstract void draw(Canvas c, Paint p);
}
