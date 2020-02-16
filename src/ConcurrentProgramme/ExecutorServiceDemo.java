package ConcurrentProgramme;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(thread1);
        service.submit(thread2);
        service.submit(new Thread(new MyRunnable()));
        service.submit(new Thread(new MyRunnable()));

        service.shutdown();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadName: " + Thread.currentThread().getName() + "---- " + i);
        }
    }
}

