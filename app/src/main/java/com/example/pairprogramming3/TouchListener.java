package com.example.pairprogramming3;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;


public class TouchListener implements View.OnTouchListener {
    MainActivity mainActivity;
    GestureDetectorCompat gestureDetectorCompat;

    public TouchListener(MainActivity ma) {
        this.mainActivity = ma;
        gestureDetectorCompat = new GestureDetectorCompat(this.mainActivity, new MyGestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gestureDetectorCompat.onTouchEvent(motionEvent);
        int maskedAction = motionEvent.getActionMasked();
        switch(maskedAction){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                mainActivity.rotatePhoto(180);
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mainActivity.rotatePhoto(0);
            case MotionEvent.ACTION_CANCEL:
                for(int i= 0, size = motionEvent.getPointerCount(); i< size; i++){
                    int id = motionEvent.getPointerId(i);
                }
                break;
        }
        return true;
    }



    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return super.onDoubleTap(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }
    }
}