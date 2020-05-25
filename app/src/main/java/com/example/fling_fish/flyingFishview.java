package com.example.fling_fish;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class flyingFishview extends View
{
    private Bitmap fish[] = new Bitmap[2];
    private int fishX = 10;
    private int fishY = 550;
    private int fishSpeed;
    private int canvasWitdh,canvasHight;

    private int yellowx,yellowy,yellowspeed = 16;
    private Paint yellowpaint = new Paint();

    private int score;

    private int grrenx,greeny,greenspeed = 20;
    private Paint greenpaint = new Paint();
    private boolean touch = false;
    private Bitmap backgroundImage;
    private Paint scorePaint = new Paint();
    private Bitmap life[] = new Bitmap[2];

    public flyingFishview(Context context) {
        super(context);
        fish[0] = BitmapFactory.decodeResource(getResources(), R.drawable.fish1);
        fish[1] = BitmapFactory.decodeResource(getResources(), R.drawable.fish2);
        backgroundImage = BitmapFactory.decodeResource(getResources(),R.drawable.background);

        yellowpaint.setColor(Color.YELLOW);
        yellowpaint.setAntiAlias(false);

        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);
        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.hearts);
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.heart_grey);

        score = 0;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWitdh = canvas.getWidth();
        canvasHight = canvas.getHeight();

        canvas.drawBitmap(backgroundImage,0,0,null);
        int minFishy = fish[0].getHeight();
        int maxFishy = canvasHight - fish[0].getHeight();
        fishY = fishY + fishSpeed;
        if (fishY<minFishy)
        {
        fishY = minFishy;
        }
        if (fishY>maxFishy)
        {
            fishY=maxFishy;
        }
        fishSpeed = fishSpeed + 2;
        if (touch)
        {
            canvas.drawBitmap(fish[1],fishX,fishY,null);
            touch = false;
        }
        else
        {
            canvas.drawBitmap(fish[0],fishX,fishY,null);
        }

        yellowx = yellowx - yellowspeed;
        if (hitballchec(yellowx,yellowy))
        {
            score = score + 10;
            yellowx = -100;
        }
        if (yellowx<0)
        {
            yellowx = canvasWitdh + 21;
            yellowy = (int) Math.floor(Math.random() * (maxFishy - minFishy)) + minFishy;
        }
        canvas.drawCircle(yellowx,yellowy,25,yellowpaint);

        canvas.drawText("Score :" + score, 20,60,scorePaint );
        canvas.drawBitmap(life[0],1040,10,null);
        canvas.drawBitmap(life[0],1170,10,null);
        canvas.drawBitmap(life[0],1300,10,null);
    }

    public boolean hitballchec(int x,int y)
    {
        if (fishX<x && x<(fishX+fish[0].getWidth()) && fishY<y && y<(fishY+fish[0].getHeight()))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
        touch = true;
         fishSpeed = -22;
        }
        return true;
    }

}

