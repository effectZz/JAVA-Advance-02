package myself;

import java.util.concurrent.CountDownLatch;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 使用CountDownLatch的方式 初始化线程1 当执行了countDown() 则减少1
 */
public class Homework3 {

    private volatile Integer number = 0;
    private final CountDownLatch countDownLatch = new CountDownLatch(1);;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        Homework3 homework3 = new Homework3();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Thread thread = new Thread(() -> {
            homework3.sum(36);
        });
        thread.start();

        int result = 0; //这是得到的返回值
        try {
            result = homework3.getNumber();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private int getNumber() throws InterruptedException {
        countDownLatch.await();
        return number;
    }

    private void sum(int value) {
        number = fibo(value);
        countDownLatch.countDown();
    }

    private int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
