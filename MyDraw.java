package com.example.a4032020;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {
    int w, h;
    private  int myR;
    private  Paint paint;
    public MyDraw(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        myR = 500;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawCircles(canvas, w/2, h/2, myR);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(myR > 50){
            myR -=50;
        }
        else {
            myR = 500;
        }
        invalidate();
        return false;
    }

    public void drawCircles(Canvas canvas, int x, int y, int r){
            canvas.drawCircle(x, y, r, paint);

            if(r > 50) {
                drawCircles(canvas, x, y - r, r / 2);
                drawCircles(canvas, x + r, y, r / 2);
                drawCircles(canvas, x, y + r, r / 2);
                drawCircles(canvas, x - r, y, r / 2);
            }
        }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
    }
}
