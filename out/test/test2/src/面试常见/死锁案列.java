package 面试常见;

import ConcurrentProgramme.NotifyUntil5.Run;

public class 死锁案列 {
    static Object o1 = new Object();
    static Object o2 = new Object();
    public static void main(String[] args) {
        Thread a1 = new Thread(new Lock1());
        Thread a2 = new Thread(new Lock2());
        a1.start();
        a2.start();
    }
}

class Lock1 implements Runnable {
    @Override
    public void run() {
        synchronized (死锁案列.o1) {
            try {
                System.out.println("get o1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (死锁案列.o2) {
                System.out.println("get o2");
            }
        }
    }
}

class Lock2 implements Runnable {
    @Override
    public void run() {
        synchronized (死锁案列.o2) {
            try {
                System.out.println("get o2");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (死锁案列.o1) {
                System.out.println("get o1");
            }
        }
    }
}