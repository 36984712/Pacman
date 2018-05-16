package com.example.ruich.pacman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class GameActivity extends AppCompatActivity implements GameOver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameactivity);
        PacmanView pacmanView = (PacmanView) findViewById(R.id.pacmanview);
        pacmanView.registerGameOver(this);
        Button left = (Button) findViewById(R.id.left);

    }

    @Override
    public void gameOver() {
        setResult(AppCompatActivity.RESULT_OK);
        finish();
    }
}
