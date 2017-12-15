package com.fallwater.applicationtest1710;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.fallwater.applicationtest1710.base.BaseActivity;
import com.fallwater.applicationtest1710.test.MutableForegroundColorSpan;
import com.fallwater.applicationtest1710.test.MutiThread;
import com.fallwater.applicationtest1710.test.TypeWriterSpanGroup;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout01);
        test();
    }

    private void test() {
//        typeWriter(tv);
//        lottie();
        threads();

    }


    private ExecutorService mExecutorService;

    /**
     * 测试多线程
     */
    private void threads() {
        mExecutorService = Executors.newFixedThreadPool(3);
        final MutiThread mutiThread = new MutiThread();
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    mutiThread.produce();
                }
            }
        });

        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    mutiThread.consume();
                }
            }
        });
    }

    @OnClick({R.id.button1})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                break;
//            case R.id.id_tv_framespan:
//                Log.d(TAG, files.get(index));
//                Toast.makeText(MainActivity.this, "当前播放的json文件:" + files.get(index),
//                        Toast.LENGTH_SHORT).show();
//                lottieAni(files.get(index));
//                index++;
//                if (index == files.size()) {
//                    index = 0;
//                }
//                break;
            default:
                break;
        }
    }

    /**
     * 测试lottie动画
     */

    private void lottie() {
        LottieAnimationView mLottieAnimationView;

        List<String> files = null;

        int index;
//        mLottieAnimationView = findViewById(R.id.id_tv_framespan);
        try {
            String[] allFiles = getAssets().list("");
            Log.d(TAG, "***************");

            if (files == null) {
                files = new ArrayList<String>();
            } else {
                files.clear();
            }
            for (int i = 0; i < allFiles.length; i++) {
                if (!TextUtils.isEmpty(allFiles[i]) && allFiles[i].endsWith(".json")) {
                    files.add(allFiles[i]);
                    Log.d(TAG, "***************" + allFiles[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lottieAni(String fileName, final LottieAnimationView lottieAnimationView) {
        try {
            LottieComposition.Factory.fromAssetFileName(this, fileName,
                    new OnCompositionLoadedListener() {
                        @Override
                        public void onCompositionLoaded(@Nullable LottieComposition composition) {
                            if (composition != null) {
                                lottieAnimationView.setComposition(composition);
                                lottieAnimationView.setProgress(0.333f);
                                lottieAnimationView.playAnimation();
                                lottieAnimationView.loop(true);
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试打字机效果
     */
    private void typeWriter(final TextView tv) {
        final Property<TypeWriterSpanGroup, Float> TYPE_WRITER_GROUP_ALPHA_PROPERTY =
                new Property<TypeWriterSpanGroup, Float>(Float.class,
                        "TYPE_WRITER_GROUP_ALPHA_PROPERTY") {
                    @Override
                    public void set(TypeWriterSpanGroup spanGroup, Float value) {
                        Log.d("fall", "value:" + value);
                        spanGroup.setAlpha(value);
                    }

                    @Override
                    public Float get(TypeWriterSpanGroup spanGroup) {
                        Log.d("fall", "value:" + spanGroup.getAlpha());
                        return spanGroup.getAlpha();
                    }
                };

        String val = "helloworld,helloworld!helloworld,helloworld!helloworld";
        final SpannableString spannableString = new SpannableString(val);
        // 添加Span
        final TypeWriterSpanGroup group = new TypeWriterSpanGroup(0);
        for (int index = 0; index <= val.length() - 1; index++) {
            MutableForegroundColorSpan span = new MutableForegroundColorSpan();
            group.addSpan(span);
            spannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        // 添加动画
        ObjectAnimator objectAnimator = ObjectAnimator
                .ofFloat(group, TYPE_WRITER_GROUP_ALPHA_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                tv.setText(spannableString);
            }
        });
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }


}
