package com.fallwater.applicationtest1710.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Fallwater潘建波 on 2017/12/16
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class AomicTest {

    public int shareValue = 0;

    public AtomicInteger mAtomicInteger = new AtomicInteger();

    public void increase() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shareValue++;
        }
    }

    public void increase2() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mAtomicInteger.incrementAndGet();
        }
    }


}
