package com.example.fling_fish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private  flyingFishview gameView;
    private Handler handler = new Handler();
    private final static long Intervel = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new flyingFishview(this);
        setContentView(gameView);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
            handler.post(new Runnable() {
                @Override
                public void run()
                {
               gameView.invalidate();
                }
            });
            }
        },0,Intervel);
    }
}
