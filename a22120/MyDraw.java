package com.example.a22120;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyDraw extends SurfaceView implements SurfaceHolder.Callback {
    DrawnThread drawnThread;

    public MyDraw(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawnThread = new DrawnThread(getContext(), surfaceHolder);
        drawnThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
drawnThread.stopRequest();
boolean retry = true;
while (retry){
    try {
        drawnThread.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    retry = false;
}
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawnThread.setXY((int)event.getX(),(int) event.getY());
        return  true;
    }
}
