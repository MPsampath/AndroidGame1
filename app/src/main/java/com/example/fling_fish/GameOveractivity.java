package com.example.fling_fish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOveractivity extends AppCompatActivity
{
    private Button startGameAgain;
    private TextView Displayscoer;
    private String score;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_overactivity);

        score = getIntent().getExtras().get("score").toString();

        startGameAgain = (Button) findViewById(R.id.play_again_btn);
       Displayscoer = (TextView) findViewById(R.id.displyscor);

        startGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(GameOveractivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });

        Displayscoer.setText("score = " + score);
    }
}
