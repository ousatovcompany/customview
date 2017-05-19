package com.example.ousatov.customview.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.ousatov.customview.R;


public class MyCustomView extends LinearLayout {
    public MyCustomView(Context context) {
        super(context);
        initViews();
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
    }

    protected void inflateLayout() {
        inflate(getContext(), R.layout.customview, this);
    }

    protected void initViews() {
        inflateLayout();
    }
}
