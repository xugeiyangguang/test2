package ConcurrentProgramme.Bank;

public class Synchronize {
    public static void main(String[] args) {
        Money money = new Money(5);
        Thread get = new Thread(new getThread(money, 2));
        Thread save = new Thread(new saveThread(money, 1));
        get.start();
        save.start();
    }
}
class Money{
    int money;

    public Money(int base) {
        money = base;
    }

    public synchronized void get(int number) throws InterruptedException {
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

class getThread implements Runnable {
    Money money;
    int number;

    public getThread(Money money, int number) {
        this.money = money;
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 3; i > 0; i--) {
            try {
                money.get(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class saveThread implements Runnable {
    Money money;
    int number;

    public saveThread(Money money, int number) {
        this.money = money;
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 3; i > 0; i--) {
            try {
                money.save(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}