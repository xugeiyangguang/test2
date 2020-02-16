package ConcurrentProgramme;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer2 producer2 = new Producer2(resource);
        Consumer2 consumer2 = new Consumer2(resource);
        Consumer2 consumer3 = new Consumer2(resource);
        Consumer2 consumer4 = new Consumer2(resource);
        producer2.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}

class Resource{
    LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
    public void add() {
        try {
            blockingQueue.put(1);
            System.out.println("生产者：" + Thread.currentThread().getName() + " 生产了一件产品，现在一共有产品：" + blockingQueue.size() + "个产品");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void delete() {
        try {
            blockingQueue.take();
            System.out.println("生产者：" + Thread.currentThread().getName() + " 消费了一件产品，现在一共有产品：" + blockingQueue.size() + "个产品");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Producer2 extends Thread{
    Resource resource;

    public Producer2(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.add();
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer2 extends Thread {
    Resource resource;

    public Consumer2(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.delete();
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
