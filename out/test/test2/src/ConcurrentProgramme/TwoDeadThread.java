package ConcurrentProgramme;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//两个线程的死锁。有两个锁，自己持有一个再去申请另外一个
public class TwoDeadThread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    public static void main(String[] args) {
        Thread s1 = new Thread(new Lock1());
        Thread s2 = new Thread(new Lock2());
        s1.start();
        s2.start();
    }
}
class Lock1 implements Runnable{


    @Override
    public void run() {
        synchronized (TwoDeadThread.o1){
            try {
                System.out.println("get o1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TwoDeadThread.o2){
                System.out.println("get o2");
            }
        }
    }
}

class Lock2 implements Runnable{
    @Override
    public void run() {
        synchronized (TwoDeadThread.o2){
            try {
                System.out.println("get o2");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TwoDeadThread.o1){
                System.out.println("get o1");
            }
        }
    }
}
