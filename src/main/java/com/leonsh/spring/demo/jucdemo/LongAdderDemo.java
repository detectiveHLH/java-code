package com.leonsh.spring.demo.jucdemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * LongAdderDemo
 *
 * @author leonsh
 * @date 2022-03-09 12:55
 **/
@Slf4j
public class LongAdderDemo {
    private static final int TASK_AMOUNT = 10;
    private static final int turns = 100000000;

    public static void main(String[] args) {
//        testAtomicLong();
        testLongAdder();
    }

    public static void testAtomicLong() {
        ExecutorService pool = Executors.newFixedThreadPool(TASK_AMOUNT);
        AtomicLong atomicLong = new AtomicLong(0);

        CountDownLatch countDownLatch = new CountDownLatch(TASK_AMOUNT);
        long start = System.currentTimeMillis();
        for (int i = 0; i < TASK_AMOUNT; i++) {
            pool.submit(() -> {
                try {
                    for (int j = 0; j < turns; j++) {
                        atomicLong.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        float time = (System.currentTimeMillis() - start) / 1000F;
        log.info("运行时长为:{}", time);
        log.info("累加结果为:{}", atomicLong.get());
    }

    public static void testLongAdder() {
        ExecutorService pool = Executors.newFixedThreadPool(TASK_AMOUNT);
        LongAdder longAdder = new LongAdder();

        CountDownLatch countDownLatch = new CountDownLatch(TASK_AMOUNT);
        long start = System.currentTimeMillis();
        for (int i = 0; i < TASK_AMOUNT; i++) {
            pool.submit(() -> {
                try {
                    for (int j = 0; j < turns; j++) {
                        longAdder.add(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        float time = (System.currentTimeMillis() - start) / 1000F;
        log.info("运行时长为:{}", time);
        log.info("累加结果为:{}", longAdder.longValue());
    }
}
