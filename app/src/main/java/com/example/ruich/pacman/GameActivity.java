package com.example.ruich.pacman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity implements GameOver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameactivity);
        final PacmanView pacmanView = (PacmanView) findViewById(R.id.pacmanview);
        pacmanView.registerGameOver(this);
        Button left = (Button) findViewById(R.id.left);
        Button right = (Button) findViewById(R.id.right);
        Button up = (Button) findViewById(R.id.up);
        Button down = (Button) findViewById(R.id.down);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pacmanView.pacMove("left");
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pacmanView.pacMove("up");
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pacmanView.pacMove("down");
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pacmanView.pacMove("right");
            }
        });
    }

    @Override
    public void gameOver() {
        setResult(AppCompatActivity.RESULT_OK);
        finish();
    }
}
