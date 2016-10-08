package com.zhi.www.zoomview.zoom;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/10/8.
 */
public abstract class ZoomView<V extends View> {

    private static final float MIN_DISTANCE = 10.0f;


    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO =2;

    private int count = 0;
    private float oldDistance;

    private V view;

    public ZoomView(V view){
        this.view = view;
        setTouchListener();
    }

    public void setTouchListener(){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        count = ONE;
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_POINTER_UP:
                        count = ZERO;
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        oldDistance = distance(event);
                        if(oldDistance > MIN_DISTANCE){
                            count = TWO;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if(count== TWO) {
                            float newDistance = distance(event);
                            if (oldDistance < newDistance) {
                                zoomOut();
                            }
                            if (oldDistance > newDistance) {
                                zoomIn();
                            }
                        }
                        break;
                }

                return true;
            }
        });
    }

    public abstract void zoomOut();

    public abstract void zoomIn();

    public float distance(MotionEvent event){
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float)Math.sqrt(x*x + y*y);
    }
}
