package ConcurrentProgramme.Bank;

public class Volatile {
    public static void main(String[] args) {
        Money3 money = new Money3(5);
        Thread get = new Thread(new getThread3(money));
        Thread save = new Thread(new saveThread3(money));
        get.start();
        save.start();
    }
}
class Money3{
    volatile int money;

    public Money3(int base) {
        money = base;
    }

    public void get(int number) throws InterruptedException {
        Thread.sleep((long)Math.random()*1000);
        money -= number;
    }

    public void save(int number) throws InterruptedException {
        Thread.sleep((long)Math.random()*1000);
        money += number;

    }

    public int show() {
        return money;
    }

}

class getThread3 implements Runnable {
    Money3 money;

    public getThread3(Money3 money) {
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
class saveThread3 implements Runnable {
        Money3 money;

        public saveThread3(Money3 money) {
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