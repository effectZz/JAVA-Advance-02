package com.example.demo.no8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoReduce {
    private final static String LOCK = "redis_lock";

    private static int amount = 10;

//    ExecutorService service = Executors.newFixedThreadPool(3);
//    final CountDownLatch latch = new CountDownLatch(3);

    public static void lockTest() {
        if (!RedisLock.getInstance().lock(LOCK, 2)) {
            System.out.println("获取锁失败");
            return;
        }

        try {
            Thread.sleep(5000);
            amount -= 1;
//            latch.countDown();//当前线程调用此方法，则计数减一
            System.out.printf("库存减一 amount: %d\n", amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //释放
        RedisLock.getInstance().release(LOCK);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(DemoReduce::lockTest);
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(DemoReduce::lockTest);
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(DemoReduce::lockTest);
        thread3.start();
        thread3.join();

//        DemoReduce demoReduce = new DemoReduce();
//        for (int i = 0; i < 3; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    demoReduce.lockTest();
//                    demoReduce.latch.countDown();
//                }
//            };
//            demoReduce.service.execute(runnable);
//        }
//        try {
//            demoReduce.latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
