package com.fallwater.applicationtest1710.test;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/**
 * @author Fallwater潘建波 on 2017/12/1
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class MutableForegroundColorSpan extends CharacterStyle
        implements UpdateAppearance {

    public static final String TAG = "MutableForegroundColorSpan";

    private int mColor = Color.BLACK;

    private int mAlpha = 0;

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setColor(mColor);
        tp.setAlpha(mAlpha);
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public void setAlpha(int alpha) {
        mAlpha = alpha;
    }
}
