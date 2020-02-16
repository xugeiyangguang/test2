package ConcurrentProgramme.Bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lockk {
    public static void main(String[] args) {
        Money1 money1 = new Money1(5);
        Lock lock = new ReentrantLock();
        Thread get = new Thread(new getThread1(money1, 1, lock));
        Thread save = new Thread(new saveThread1(money1, 2, lock));
        get.start();
        save.start();
    }
}
class Money1{
    int money;
    public Money1(int base) {
        this.money = base;
    }

    public void get(int number) throws InterruptedException {
            Thread.sleep((long)Math.random()*1000);
            money = money - number;
            System.out.println(Thread.currentThread().getName() + "取出" + number + "，还有" + money);
    }

    public synchronized void save(int number) throws InterruptedException {
        Thread.sleep((long)Math.random()*1000);
        money = money + number;
        System.out.println(Thread.currentThread().getName() + "存入" + number + "，还有" + money);
    }
}
class getThread1 implements Runnable {
    Money1 money;
    int num;
    Lock lock;

    public getThread1(Money1 money, int num, Lock lock) {
        this.money = money;
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            try {
                for (int i = 0; i < 10; i++) {
                    money.get(num);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }
}

class saveThread1 implements Runnable {
    Money1 money;
    int num;
    Lock lock;

    public saveThread1(Money1 money, int num, Lock lock) {
        this.money = money;
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            try {
                for (int i = 0; i < 10; i++) {
                    money.save(num);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }
}