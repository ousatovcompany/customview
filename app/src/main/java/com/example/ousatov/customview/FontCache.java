package com.example.ousatov.customview;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FontCache {

    private static String TAG = "FontCache";
    private static final String FONT_DIR = "fonts";
    private static Map<String, Typeface> cache = new HashMap<>();
    private static Map<String, String> fontMapping = new HashMap<>();
    private static FontCache instance;

    public static void initCache() {
        instance = new FontCache();
    }

    private FontCache() {
        AssetManager am = MyApplication.getInstance().getResources().getAssets();
        String fileList[];
        try {
            fileList = am.list(FONT_DIR);
        } catch (IOException e) {
            Log.e(TAG, "Error loading assets.fonts from assets/assets.fonts.");
            return;
        }

        for (String filename : fileList) {
            String alias = filename.substring(0, filename.lastIndexOf('.'));
            fontMapping.put(alias, filename);
            fontMapping.put(alias.toLowerCase(), filename);
        }
    }

    public Typeface get(String fontName) {
        String fontFilename = fontMapping.get(fontName);
        if (fontFilename == null) {
            Log.e(TAG, "Couldn't find font " + fontName + ". Maybe you need to call addFont() first?");
            return null;
        }
        if (cache.containsKey(fontName)) {
            return cache.get(fontName);
        } else {
            Typeface typeface = Typeface.createFromAsset(MyApplication.getInstance().getAssets(), FONT_DIR + "/" + fontFilename);
            cache.put(fontFilename, typeface);
            return typeface;
        }
    }

    public static FontCache getInstance() {
        return instance;
    }
//
//    @BindingAdapter({"bind:font"})
//    public static void setFont(TextView textView, String fontName) {
//        textView.setTypeface(instance.get(fontName));
//    }


}
