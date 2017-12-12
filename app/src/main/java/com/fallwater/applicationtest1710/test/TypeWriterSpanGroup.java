package com.fallwater.applicationtest1710.test;

import java.util.ArrayList;

/**
 * @author Fallwater潘建波 on 2017/12/1
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class TypeWriterSpanGroup {

    private final float mAlpha;

    private final ArrayList<MutableForegroundColorSpan> mSpans;

    public TypeWriterSpanGroup(float alpha) {
        mAlpha = alpha;
        mSpans = new ArrayList<MutableForegroundColorSpan>();
    }

    public void addSpan(MutableForegroundColorSpan span) {
        span.setAlpha((int) (mAlpha * 255));
        mSpans.add(span);
    }

    public void setAlpha(float alpha) {
        int size = mSpans.size();
        float total = 1.0f * size * alpha;
        for (int index = 0; index < size; index++) {
            MutableForegroundColorSpan span = mSpans.get(index);
            if (total >= 1.0f) {
                span.setAlpha(255);
                total -= 1.0f;
            } else {
                span.setAlpha((int) (total * 255));
                total = 0.0f;
            }
        }
    }

    public float getAlpha() {
        return mAlpha;
    }

}
