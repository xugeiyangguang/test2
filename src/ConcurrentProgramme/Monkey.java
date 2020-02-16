package ConcurrentProgramme;

public class Monkey {
    public static void main(String[] args) {
        Apple a = new Apple(10);
        Thread one = new One(a);
        Thread two = new Two(a);
        one.start();
        two.start();
    }
}

class Apple {
    int n;  //容量；标志位和容量都在物品中设置
    int tag = 1; //先拿一个  标志位
    public Apple(int i) {
        n = i;
    }
    public synchronized void get1() {
        while (tag == 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        n = n - 1;
        tag = 2;
        System.out.println(Thread.currentThread().getName() + ":-1,n=" + n);
        notify();
    }

    public synchronized void get2() {
        while (tag == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        n = n - 2;
        tag = 1;
        System.out.println(Thread.currentThread().getName() + ":-2,n=" + n);
        notify();
    }
}

class One extends Thread{
    Apple a;

    public One(Apple i) {
        a = i;
    }
    @Override
    public void run() {
        while (a.n >= 1) {
            a.get1();
        }

    }
}

class Two extends Thread{
    Apple a;

    public Two(Apple i) {
        a = i;
    }
    @Override
    public void run() {
        while (a.n >= 2) {
            a.get2();
        }

    }
}