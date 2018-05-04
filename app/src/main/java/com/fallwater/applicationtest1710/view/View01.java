package com.fallwater.applicationtest1710.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Fallwater潘建波 on 2018/3/27
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class View01 extends View {

    private static final String TAG = "View";

    private PointF mPointF = new PointF();

    public View01(Context context) {
        super(context);
    }

    public View01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent ACTION_DOWN");
                mPointF.x = event.getX();
                mPointF.y = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent ACTION_MOVE");
                scrollBy(0, (int) (mPointF.y - event.getY()));
                mPointF.x = event.getX();
                mPointF.y = event.getY();
                break;
            default:
                break;
        }
        return true;
    }
}
