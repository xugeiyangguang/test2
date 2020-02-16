package 重要算法;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrintAB {
    public static void main(String[] args) {
        int tag = 0;
        Lock lock = new ReentrantLock();
        Thread threadA = new A(tag, lock);
        Thread threadB = new B(tag, lock);
        threadA.start();
        threadB.start();
    }
}
class A extends Thread{
    int tag;
    Lock lock;
    public A(int i,Lock j){
        tag = i;
        lock = j;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            lock.lock();
            while (tag==1){

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            tag=1;
            System.out.print('B');
            notify();
            lock.unlock();
        }

    }
}

class B extends Thread{
    int tag;
    Lock lock;
    public B(int i,Lock j){
        tag = i;
        lock = j;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            lock.lock();
            while (tag==0){

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print('A');
            tag = 0;
            notify();
            lock.unlock();
        }

    }
}