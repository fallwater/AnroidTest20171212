package com.fallwater.applicationtest1710.test;

import com.fallwater.applicationtest1710.R;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Fallwater潘建波 on 2017/11/30
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class Notify {

    private View smallWindow;

    private WindowManager.LayoutParams smallWindowParams;

    public void createSmallWindow(Activity activity) {
        WindowManager windowManager = activity
                .getWindowManager();
        int screenWidth = windowManager.getDefaultDisplay().getWidth();
        int screenHeight = windowManager.getDefaultDisplay().getHeight();
        if (smallWindow == null) {
            LayoutInflater inflater = LayoutInflater.from(activity);
            smallWindow = inflater
                    .inflate(R.layout.layout_push_message_window, null);
            if (smallWindowParams == null) {
                smallWindowParams = new WindowManager.LayoutParams();
                smallWindowParams.type = WindowManager.LayoutParams.TYPE_TOAST;
                smallWindowParams.format = PixelFormat.RGBA_8888;
                smallWindowParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                smallWindowParams.gravity = Gravity.LEFT | Gravity.TOP;
                smallWindowParams.width = screenWidth;
                smallWindowParams.height = smallWindow.getHeight();
                smallWindowParams.x = 0;
                smallWindowParams.y = 0;
            }
            windowManager.addView(smallWindow, smallWindowParams);
        }

        ImageView iconView = smallWindow.findViewById(R.id.icon);
        TextView body = smallWindow.findViewById(R.id.messageBody);
        TextView title = smallWindow.findViewById(R.id.messageTitle);
//        iconView.setImageResource(R.drawable.ic_launcher_foreground);
        title.setText("messageTitle");
        body.setText("messageBody");
    }

    private void addNotifycation(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        int screenWidth = windowManager.getDefaultDisplay().getWidth();
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.layout_push_message_window, null);
        TextView body = view.findViewById(R.id.messageBody);
        TextView title = view.findViewById(R.id.messageTitle);
        title.setText("messageTitle");
        body.setText("messageBody");
//        Button floatingButton = new Button(this);
//        floatingButton.setText("button");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0, 0,
                PixelFormat.TRANSPARENT
        );
        // flag 设置 Window 属性
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        // type 设置 Window 类别（层级）
        layoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        layoutParams.width = screenWidth;
        layoutParams.x = -10;
        layoutParams.y = -20;

        windowManager.addView(view, layoutParams);
//        new Notify().createSmallWindow(this);
    }

}
