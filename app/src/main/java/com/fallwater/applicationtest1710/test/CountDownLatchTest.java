package com.fallwater.applicationtest1710.test;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

/**
 * @author Fallwater潘建波 on 2017/12/16
 * @mail 1667376033@qq.com
 * 功能描述:
 * CountDownLatch是J.U.C提供的一个线程同步辅助类，
 * 作用和Thread.join()有些类似。CountDownLatch内部维护了一个计数器，
 * 在创建实例时需要定义其初始值。当一个线程调用await()方法后将进行等待，直到计数器为零，
 * 每执行一次countDown()方法可以将计数器的值减一。
 */
public class CountDownLatchTest {

    public CountDownLatch downLatch = new CountDownLatch(3);

    public void work(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        downLatch.countDown();
        Log.d("tag","current thread:" +Thread.currentThread()+" work end");
    }

}
