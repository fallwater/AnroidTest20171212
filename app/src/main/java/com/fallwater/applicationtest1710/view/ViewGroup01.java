package com.fallwater.applicationtest1710.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * @author Fallwater潘建波 on 2018/3/27
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class ViewGroup01 extends RelativeLayout {

    private static final String TAG = "ViewGroup";

    private PointF mPointF = new PointF();

    private boolean isResolve;

    private boolean isInterrupt;

    public ViewGroup01(Context context) {
        super(context);
    }

    public ViewGroup01(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroup01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onInterceptTouchEvent ACTION_DOWN");
                mPointF.x = ev.getX();
                mPointF.y = ev.getY();
                return false;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onInterceptTouchEvent ACTION_MOVE");
                if (!isResolve) {
                    isResolve = true;
                    /**
                     * 水平移动
                     */
                    isInterrupt = Math.pow(mPointF.x - ev.getX(), 2) - Math.pow(mPointF.y - ev.getY(), 2) > 0;
                }
                return isInterrupt;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent ACTION_MOVE");
                scrollBy((int) (mPointF.x - event.getX()), 0);
                mPointF.x = event.getX();
                mPointF.y = event.getY();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
