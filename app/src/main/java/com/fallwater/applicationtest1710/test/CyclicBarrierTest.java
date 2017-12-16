package com.fallwater.applicationtest1710.test;

import android.util.Log;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Fallwater潘建波 on 2017/12/16
 * @mail 1667376033@qq.com
 * 功能描述:
 * CyclicBarrier也是J.U.C提供的一个线程同步辅助类，直译过来就是“环形栅栏”的意思，
 * 它可以将一定数量的线程阻塞在“环形栅栏”内，达到临界值后打开“栅栏”让这些线程继续执行，
 * 下面这个可能不太恰当的使用测试足以描述它的作用。
 */
public class CyclicBarrierTest {

    private static final int NUM = 2;

    /**
     * 达到上限后从新开始新的一轮循环
     */
    private CyclicBarrier mCyclicBarrier = new CyclicBarrier(NUM, () -> {
        Log.d("tag", "栅栏：“这么多猪，我恐怕扛不住了”");
    });

    public void go() {
        Log.d("tag", "小猪[" + Thread.currentThread().getName() + "] 在栅栏边等待其他小猪");
        try {
            mCyclicBarrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        Log.d("tag", "猪到齐了，小猪[" + Thread.currentThread().getName() + "] 与其他小猪一起冲破栅栏");

    }
}
