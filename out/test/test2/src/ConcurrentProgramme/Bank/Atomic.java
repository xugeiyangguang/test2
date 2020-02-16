package ConcurrentProgramme.Bank;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    public static void main(String[] args) {
        Money4 money = new Money4(5);
        Thread get = new Thread(new getThread4(money));
        Thread save = new Thread(new saveThread4(money));
        get.start();
        save.start();
    }
}
class Money4{
    AtomicInteger money;

    public Money4(int base) {
        money = new AtomicInteger(base);
    }


    public void get(int number) throws InterruptedException {
        Thread.sleep((long)Math.random()*1000);
        money.addAndGet(-(number));
    }

    public void save(int number) throws InterruptedException {
        Thread.sleep((long)Math.random()*1000);
        money.addAndGet(number);

    }

    public AtomicInteger show() {
        return money;
    }

}
class getThread4 implements Runnable {
    Money4 money;

    public getThread4(Money4 money) {
        this.money = money;
    }
    @Override
    public void run() {
        for (int i = 20; i > 0; i--) {
            try {
                money.get(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "取出" + 1 + "，还有" + money.show());
        }

    }
}
class saveThread4 implements Runnable {
    Money4 money;

    public saveThread4(Money4 money) {
        this.money = money;
    }
    @Override
    public void run() {
        for (int i = 20; i > 0; i--) {
            try {
                money.save(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存入" + 2 + "，还有" + money.show());
        }

    }
}