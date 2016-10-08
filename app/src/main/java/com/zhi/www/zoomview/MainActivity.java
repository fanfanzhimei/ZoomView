package com.zhi.www.zoomview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.zhi.www.zoomview.zoom.ZoomTextView;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        new ZoomTextView(mTextView, 0.5f);
    }
}
