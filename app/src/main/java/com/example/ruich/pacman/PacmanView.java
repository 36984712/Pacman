package com.example.ruich.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class PacmanView extends View implements View.OnTouchListener , Runnable {

    public static final int STEPDELAY = 100;
    public static final int DEFAULTCOLOUR = Color.BLACK;
    public static final float DEFAULTPENWIDTH = 3.0f;
    Paint paint;
    Handler repaintHandler;
    Game game;
    ArrayList<GameOver> observers ;

    public PacmanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(DEFAULTCOLOUR);
        paint.setStrokeWidth(DEFAULTPENWIDTH);
        this.setOnTouchListener(this);
        observers = new ArrayList<GameOver>();
        game = new Game();

        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, STEPDELAY);
    }

    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, PacmanView.STEPDELAY);
        }
    }

    public void registerGameOver(GameOver gameover) {
        observers.add(gameover);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float w = (float) v.getWidth();
        float h = (float) v.getHeight();
        game.touch(event.getX() / w, event.getY() / h);
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        game.draw(canvas, paint);
    }

    public boolean step() {
        game.step();
        if (game.hasWon() || game.shipHit()) {
            notifyGameOver();
            return false;
        }
        this.invalidate();
        return true;
    }

    private void notifyGameOver() {
        for (GameOver o : observers) o.gameOver();
    }
}
