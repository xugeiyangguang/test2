package ConcurrentProgramme;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);


        Thread a = new Son(latch);
        Thread a1 = new Son(latch);
        Thread a2 = new Son(latch);
        Thread a3 = new Son(latch);
        Executor executor = Executors.newFixedThreadPool(4);
        executor.execute(a);
        executor.execute(a1);
        executor.execute(a2);
        executor.execute(a3);
        try {
            latch.await();
            System.out.println("等他们先执行，我最后执行！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son extends Thread {
    CountDownLatch i;

    public Son(CountDownLatch countDownLatch) {
        i = countDownLatch;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            i.countDown();
        }

    }
}
