package com.example.ousatov.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.example.ousatov.customview.FontCache;
import com.example.ousatov.customview.R;

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    public MyTextView(Context context) {
        super(context);
        initView(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray;
        int fontStyle = 0;
        int textStyle = 0;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        if (typedArray != null) {
            fontStyle = typedArray.getInt(R.styleable.MyTextView_myFont, 0);
            textStyle = attrs.getAttributeIntValue(
                    "http://schemas.android.com/apk/res/android",
                    "textStyle",
                    Typeface.NORMAL);
            typedArray.recycle();
        }

        String fontName = getFontNameByStyle(fontStyle);
        setTypeface(FontCache.getInstance().get(fontName), textStyle);
    }

    private String getFontNameByStyle(int style) {
        String fontName;
        switch (style) {
            case 0:
            default:
                fontName = "alegreya-regular";
                break;
            case 1:
                fontName = "steelworks-vintage-demo";
                break;
        }
        return fontName;
    }
}
