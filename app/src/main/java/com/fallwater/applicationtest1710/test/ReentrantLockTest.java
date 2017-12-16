package com.fallwater.applicationtest1710.test;

import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fallwater潘建波 on 2017/12/16
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class ReentrantLockTest {

    private final ReentrantLock mLock = new ReentrantLock();

    private final Condition mCondition = mLock.newCondition();

    private String mContent = "old";

    private final static int TIME = 2000;

    public void work() {
        mLock.lock();
        try {
            Log.d("tag", "word start...");
            mCondition.await();
            Log.d("tag", "word end...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }

    public void endWork() {
        mLock.lock();
        try {
            mCondition.signalAll();
        } finally {
            mLock.unlock();
        }
    }


    public void write() {
        mLock.lock();
        Log.d("tag", Thread.currentThread() + " lock");
        try {
            try {
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mContent = "new";
            Log.d("tag", Thread.currentThread() + "write content is " + mContent);
        } finally {
            mLock.unlock();
            Log.d("tag", Thread.currentThread() + " Unlock");

        }
    }

    public void read() {
        mLock.lock();
        Log.d("tag", Thread.currentThread() + " lock");
        try {
//            try {
//                Thread.sleep(TIME);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Log.d("tag", Thread.currentThread() + "read content is " + mContent);
        } finally {
            mLock.unlock();
            Log.d("tag", Thread.currentThread() + " Unlock");

        }
    }
}
