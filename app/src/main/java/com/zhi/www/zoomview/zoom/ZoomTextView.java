package com.zhi.www.zoomview.zoom;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/8.
 */
public class ZoomTextView extends ZoomView<TextView>{
    private static final float MIN_SIZE = 10.0f;
    private static final float MAX_SIZE = 180.0f;

    private TextView view;
    private float scale;
    private float textSize;

    public ZoomTextView(TextView view, float scale) {
        super(view);
        this.view = view;
        this.scale = scale;
        textSize = view.getTextSize();
    }

    @Override
    public void zoomOut() {
        textSize = textSize+scale;
        if(textSize > MAX_SIZE){
            textSize = MAX_SIZE;
        }
        view.setTextSize(textSize);
    }

    @Override
    public void zoomIn() {
        textSize = textSize-scale;
        if(textSize<MIN_SIZE){
            textSize = MIN_SIZE;
        }
        view.setTextSize(textSize);
    }
}
