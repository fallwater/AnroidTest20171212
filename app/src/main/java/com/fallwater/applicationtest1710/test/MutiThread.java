package com.fallwater.applicationtest1710.test;

import android.util.Log;

/**
 * @author Fallwater潘建波 on 2017/12/15
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class MutiThread {

    private int mProduct;

    private static final int MAX_PRODUCT = 100;

    private static final int MIN_PRODUCT = 0;

    /**
     * 生产产品
     */
    public synchronized void produce() {
        if (this.mProduct >= MAX_PRODUCT) {
            try {
                wait();
                Log.d("tag", "产品已满，请稍后再生产");
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mProduct++;
        Log.d("tag","生产者生产第" + this.mProduct + "个产品.");
        notifyAll();

    }

    /**
     * 消费产品
     */
    public synchronized void consume() {
        if (this.mProduct <= MIN_PRODUCT) {
            try {
                wait();
                Log.d("tag", "缺货，请稍后再取");
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.d("tag","消费者消费第" + this.mProduct + "个产品.");
        mProduct--;
        notifyAll();
    }

}
