package com.example.ousatov.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ousatov.customview.FontCache;
import com.example.ousatov.customview.R;


public class MyCustomView extends LinearLayout {

    private ImageView ivMain;
    private TextView tvTitle;
    private TextView tvSubtitle;

    public MyCustomView(Context context) {
        super(context);
        initViews();
        setupViews(context, null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews();
        setupViews(context, attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
        setupViews(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
        setupViews(context, attrs);
    }

    protected void inflateLayout() {
        inflate(getContext(), R.layout.customview, this);
    }

    protected void initViews() {
        inflateLayout();
        ivMain = (ImageView) findViewById(R.id.image_main);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvSubtitle = (TextView) findViewById(R.id.tv_subtitle);
    }

    private void setupViews(Context context, @Nullable AttributeSet attrs) {
        setupTexts(context, attrs);
        setupImage(context, attrs);
    }

    private void setupTexts(Context context, @Nullable AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArray;
        int fontStyle = 0;
        String titleText = "";
        String subtitleText = "";

        float titleTextSize = 0;
        float subtitleTextSize = 0;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        if (typedArray != null) {
            fontStyle = typedArray.getInt(R.styleable.MyCustomView_myFont, 0);
            titleText = typedArray.getString(R.styleable.MyCustomView_mainText);
            subtitleText = typedArray.getString(R.styleable.MyCustomView_subText);
            titleTextSize = typedArray.getDimension(R.styleable.MyCustomView_mainTextSize, 0);
            subtitleTextSize = typedArray.getDimension(R.styleable.MyCustomView_subTextSize, 0);
            typedArray.recycle();
        }

        String fontName = getFontNameByStyle(fontStyle);

        tvTitle.setTypeface(FontCache.getInstance().get(fontName), Typeface.BOLD);
        tvTitle.setText(titleText);
        tvTitle.setTextSize(titleTextSize);

        tvSubtitle.setTypeface(FontCache.getInstance().get(fontName), Typeface.ITALIC);
        tvSubtitle.setText(subtitleText);
        tvSubtitle.setTextSize(subtitleTextSize);
    }

    private void setupImage(Context context, @Nullable AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArray;
        Drawable srcImage = null;
        int imageWidth = 0;
        int imageHeight = 0;

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        if (typedArray != null) {
            srcImage = typedArray.getDrawable(R.styleable.MyCustomView_iconSrc);
            imageWidth = typedArray.getDimensionPixelSize(R.styleable.MyCustomView_iconWidth, 0);
            imageHeight = typedArray.getDimensionPixelSize(R.styleable.MyCustomView_iconHeigh, 0);
            typedArray.recycle();
        }

        ivMain.setImageDrawable(srcImage);
        ivMain.getLayoutParams().height = imageHeight;
        ivMain.getLayoutParams().width = imageWidth;
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
