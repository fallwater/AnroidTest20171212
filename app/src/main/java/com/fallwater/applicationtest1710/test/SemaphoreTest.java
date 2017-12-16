package com.fallwater.applicationtest1710.test;

import android.util.Log;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Fallwater潘建波 on 2017/12/16
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class SemaphoreTest {

    private Semaphore mSemaphore = new Semaphore(3);

    public void use() {
        try {
            mSemaphore.acquire();
            Log.d("tag", Thread.currentThread().getName() + " 正在使用卫生间");
            TimeUnit.SECONDS.sleep(3);
            Log.d("tag", Thread.currentThread().getName() + " 使用完毕");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mSemaphore.release();
        }
    }

}
