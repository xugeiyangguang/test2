package ConcurrentProgramme.NotifyUntil5;

import java.util.concurrent.locks.Lock;

public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    MyList.add();
                    System.out.println("add" + (i + 1) + "个元素");
                    if (MyList.size() == 5) {
                        lock.notifyAll();
                        System.out.println("已发出通知！");
                    }

                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
