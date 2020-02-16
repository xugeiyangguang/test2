package ConcurrentProgramme;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(6);
        Runnable target = ()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "i的值为：" + i);
            }
        };
        service.submit(target);
        service.submit(target);
        service.shutdownNow();

    }
}
