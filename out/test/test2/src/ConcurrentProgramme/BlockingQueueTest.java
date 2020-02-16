package ConcurrentProgramme;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        Thread pro = new Produc(bq);
        Thread cons = new Consum(bq);
        Thread pro2 = new Produc(bq);
        pro.start();
        cons.start();
        pro2.start();
    }

}

class Produc extends Thread {
    private ArrayBlockingQueue<String> blockingQueue;

    public Produc(ArrayBlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                blockingQueue.put("a");
                System.out.println("生产者" + Thread.currentThread().getName() + "放入一个产品！" + blockingQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Consum extends Thread {
    private ArrayBlockingQueue<String> blockingQueue;

    public Consum(ArrayBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                blockingQueue.take();
                System.out.println("消费者" + Thread.currentThread().getName() + "取出一个产品" + blockingQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}