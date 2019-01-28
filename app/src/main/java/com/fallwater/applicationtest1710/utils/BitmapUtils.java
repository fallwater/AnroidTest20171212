package com.fallwater.applicationtest1710.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * @author Fallwater潘建波 on 2019/1/26
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class BitmapUtils {

    public static Bitmap convertViewToBitMap(View view){
        // 打开图像缓存
        view.setDrawingCacheEnabled(true);
        // 必须调用measure和layout方法才能成功保存可视组件的截图到png图像文件
        // 测量View大小
        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                        .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        // 发送位置和尺寸到View及其所有的子View
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        // 获得可视组件的截图
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    public static Bitmap convertViewToBitmap(View view, int bitmapWidth, int bitmapHeight){
        Bitmap bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    public static Bitmap getBitmapFromView(View view){
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            bgDrawable.draw(canvas);
        } else {
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;
    }

    public static Bitmap round(Bitmap src,int radius){
        Bitmap dest =Bitmap.createBitmap(src.getWidth(),src.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(dest);
        Rect roundRect = new Rect(0,0,src.getWidth(),src.getHeight());
        RectF roundRectF = new RectF(0,0,src.getWidth(),src.getHeight());
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        canvas.drawRoundRect(roundRectF,radius,radius,paint);
        paint.setXfermode( new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(src,roundRect,roundRect,paint);
        return dest;
    }

}
