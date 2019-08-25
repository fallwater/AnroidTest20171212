package com.fallwater.applicationtest1710.activity;

import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.base.BaseActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.OnClick;

/**
 * @author Fallwater潘建波
 * 版权 akulaku
 * 时间 2019-08-19
 * 描述
 */
public class Activity4 extends BaseActivity {

    public static void launch(Context context){
        Intent intent = new Intent(context,Activity4.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_04;
    }


    @OnClick({R.id.start})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:

                break;
            default:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("","");

    }


}
