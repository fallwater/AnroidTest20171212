package com.fallwater.applicationtest1710.activity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.base.BaseActivity;
import com.fallwater.applicationtest1710.test.AomicTest;
import com.fallwater.applicationtest1710.test.CountDownLatchTest;
import com.fallwater.applicationtest1710.test.CyclicBarrierTest;
import com.fallwater.applicationtest1710.test.MutableForegroundColorSpan;
import com.fallwater.applicationtest1710.test.MutiThread;
import com.fallwater.applicationtest1710.test.ReentrantLockTest;
import com.fallwater.applicationtest1710.test.SemaphoreTest;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String TAG = "tag";

    private static final int THREAD_SIZE = 10;


    private ExecutorService mExecutorService = Executors.newFixedThreadPool(THREAD_SIZE);

    @BindView(R.id.button1)
    Button mButton;

    @Override
    protected void initView(Bundle savedInstanceState) {
        test();
    }

    @Override
    protected int initLayout() {
        return R.layout.test_layout01;
    }


    @OnClick({R.id.button1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
//                test();
                nextLottie();
                break;
            case R.id.id_tv_framespan:
                break;
            default:
                break;
        }
    }

    private void nextLottie() {
        Log.d(TAG, files.get(index));
        Toast.makeText(MainActivity.this, "当前播放的json文件:" + files.get(index),
                Toast.LENGTH_SHORT).show();
        lottieAni(files.get(index), mLottieAnimationView);
        index++;
        if (index == files.size()) {
            index = 0;
        }
    }

    private void test() {
//        typeWriter(tv);
        lottie();
//        threads();
//        reentrantLock();
//        conditionTest();
//        atomicText();
//        atomicText2();
//        countDownLatch();
//        cyclicBarrierTest();
//        semaphore();

    }

    private void semaphore() {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        mExecutorService.execute(semaphoreTest::use);
        mExecutorService.execute(semaphoreTest::use);
        mExecutorService.execute(semaphoreTest::use);
        mExecutorService.execute(semaphoreTest::use);
        mExecutorService.execute(semaphoreTest::use);

    }

    private void cyclicBarrierTest() {
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
        mExecutorService.execute(cyclicBarrierTest::go);
        mExecutorService.execute(cyclicBarrierTest::go);
        mExecutorService.execute(cyclicBarrierTest::go);
        mExecutorService.execute(cyclicBarrierTest::go);
    }

    private void countDownLatch() {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        mExecutorService.execute(countDownLatchTest::work);
        mExecutorService.execute(countDownLatchTest::work);
        mExecutorService.execute(countDownLatchTest::work);
        try {
            countDownLatchTest.downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        mExecutorService.execute(countDownLatchTest::work);
        Log.d("tag", "main thread word end");

    }

    private void atomicText() {
        AomicTest aomicTest = new AomicTest();
        mExecutorService.execute(aomicTest::increase);
        mExecutorService.execute(aomicTest::increase);
        mExecutorService.execute(aomicTest::increase);
        mExecutorService.execute(aomicTest::increase);
        mButton.postDelayed(() -> {
            Log.d("tag", "shareValue:" + String.valueOf(aomicTest.shareValue));
        }, 1000);
    }

    private void atomicText2() {
        AomicTest aomicTest = new AomicTest();
        mExecutorService.execute(aomicTest::increase2);
        mExecutorService.execute(aomicTest::increase2);
        mExecutorService.execute(aomicTest::increase2);
        mExecutorService.execute(aomicTest::increase2);
        mButton.postDelayed(() -> {
            Log.d("tag", "mAtomicInteger:" + aomicTest.mAtomicInteger.get() + "");
        }, 3000);
    }

    private void conditionTest() {
        ReentrantLockTest lockTest = new ReentrantLockTest();
        mExecutorService.execute(() -> {
            lockTest.work();
        });
        mExecutorService.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockTest.endWork();
        });
    }

    /**
     * 可重入锁
     */
    private void reentrantLock() {
        ReentrantLockTest lockTest = new ReentrantLockTest();
        mExecutorService.execute(lockTest::write);
        mExecutorService.execute(lockTest::read);
        mExecutorService.execute(lockTest::read);
        mExecutorService.execute(lockTest::write);
    }

    /**
     * 测试多线程
     */
    private void threads() {
        final MutiThread mutiThread = new MutiThread();
        mExecutorService.execute(() -> {
            while (true) {
                mutiThread.produce();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        mExecutorService.execute(() -> {
            while (true) {
                mutiThread.consume();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 测试lottie动画
     */

    LottieAnimationView mLottieAnimationView;

    List<String> files = null;

    int index;

    private void lottie() {

        mLottieAnimationView = findViewById(R.id.id_tv_framespan);
        try {
//            String[] allFiles = getAssets().list("test1");
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
