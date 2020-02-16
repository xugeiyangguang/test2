package ConcurrentProgramme.Bank;

import javax.print.attribute.standard.JobName;

public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank();

        MybanRunnable my1 = new MybanRunnable(bank);
        System.out.println("线程1");
        Thread th1 = new Thread(my1);
        th1.start();
        System.out.println("线程2");
        Thread th2 = new Thread(my1);
        th2.start();
    }
}
class MybanRunnable implements Runnable{

    private Bank bank;

    public MybanRunnable(Bank bank) {
        this.bank = bank;
    }
    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            bank.save(100);
            System.out.println("账户余额是---"+bank.getAccount());
        }

    }


}

class Bank{
    //需要同步的变量加上volatile
    private volatile int account = 100;

    public int getAccount() {
        return account;
    }
    //这里不再需要synchronized
    public void save(int money) {
        account += money;
    }



}
