package myself;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 使用CyclicBarrier的方式
 */
public class Homework4 {

    private volatile Integer number = 0;
    CyclicBarrier cyclicBarrier;
    
    public static void main(String[] args) {
        
        long start=System.currentTimeMillis();
        Homework4 homework4 = new Homework4();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        CyclicBarrier barrier = new CyclicBarrier(1,()->{
            int result = homework4.getNumber(); //这是得到的返回值

            // 确保  拿到result 并输出
            System.out.println("异步计算结果为："+result);

            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        });
        homework4.setCyclicBarrier(barrier); ;
        Thread thread = new Thread(() -> {
            try {
                homework4.sum(36);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        // 然后退出main线程
    }

    private void sum(int value) throws BrokenBarrierException, InterruptedException {
        number = fibo(value);
        cyclicBarrier.await();
    }
    
    private int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }


    private int getNumber() {
        return number;
    }

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
}
