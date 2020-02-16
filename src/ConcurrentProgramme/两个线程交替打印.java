package ConcurrentProgramme;

import static java.lang.Thread.sleep;

/**
 * 两个线程 交替打印12A34B56C...4950Y5152Z
 */
public class 两个线程交替打印 {
    public static void main(String[] args) {
        //建立一个同步监视器，两个线程交替访问
        Object lock = new Object();

        Thread digit = new Thread(new Runnable() {
            @Override
            public void run() {
                //要先获得lock的锁定，才能进入下面的代码块
                synchronized (lock){

                    for (int i = 1; i <= 52;){
                        System.out.print(i++);
                        System.out.print(i++);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();
                    }
                }
            }
        });

        Thread word = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    lock.notify();
                   /* try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    for (int i = 'A'; i <= 'Z';i++){
                        System.out.print((char)i);
                        try {

                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();
                    }
                }
            }
        });

        digit.start();
        word.start();
    }
}

