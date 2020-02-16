package ConcurrentProgramme;

public class PrioritySet {
    public static void main(String[] args) {
        System.out.println("main begin:" + Thread.currentThread().getPriority());
        Thread1 thread1 = new Thread1();
        thread1.start();
        Thread.currentThread().setPriority(6);
        System.out.println("main end:" + Thread.currentThread().getPriority());
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("thread1:" + Thread.currentThread().getPriority());
        Thread2 thread2 = new Thread2();
        thread2.start();
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread2:" + Thread.currentThread().getPriority());
    }
}
