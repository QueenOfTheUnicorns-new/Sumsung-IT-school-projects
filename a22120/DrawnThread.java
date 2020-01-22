package com.example.a22120;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawnThread extends Thread {
    SurfaceHolder surfaceHolder;
    private  boolean running = true;
    private Paint backpaint;
    private Paint paint;
    private int x, y, r;
    public  DrawnThread(Context context, SurfaceHolder surfaceHolder ){

        x = 0;
        y = 0;
        r = 5;
        this.surfaceHolder = surfaceHolder;
        backpaint = new Paint();
        backpaint.setStyle(Paint.Style.FILL);
        backpaint.setColor(Color.GREEN);


        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);


    }


    public  void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void stopRequest(){
        running = false;
    }

    @Override
    public void run() {
                 while (running){
                     Canvas canvas = surfaceHolder.lockCanvas();
                   // Canvas canvas = surfaceHolder.lockCanvas();
                    if(canvas != null){
try {
    canvas.drawPaint(backpaint);
    canvas.drawCircle(x, y, r, paint);
    if(r< 200) r +=5;
    Thread.sleep(200);

} catch (InterruptedException e) {
    e.printStackTrace();
} finally {surfaceHolder.unlockCanvasAndPost(canvas);


}
}
        }
    }
}
