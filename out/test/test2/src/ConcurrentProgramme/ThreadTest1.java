package ConcurrentProgramme;

/**
 * JAVA 多线程编程。
 * 用 JAVA 写一个多线程程序，如写四个线程，二个加 1，二个对一个变量减一，输出。
 */
public class ThreadTest1 {
    private static int i = 1;
    public static void main(String[] args) {
        System.out.println("之前的i值为：" + i);
        ThreadTest1 test = new ThreadTest1();
        Thread addThread1 = test.new AddThread(test);
        Thread addThread2 = test.new AddThread(test);
        Thread minusThread1 = test.new MinusThread(test);
        Thread minusThread2 = test.new MinusThread(test);
        addThread1.start();
        addThread2.start();
        minusThread1.start();
        minusThread2.start();
        System.out.println("之后的i值为：" + i);
    }

    private synchronized void add() {
        i = i + 2;
        System.out.println(Thread.currentThread().getName() + " +2 i=" + i);
    }

    private synchronized void minus() {
        i--;
        System.out.println(Thread.currentThread().getName() + " -1 i=" + i);
    }
    class AddThread extends Thread {
        ThreadTest1 test;

        public AddThread(ThreadTest1 test) {
            this.test = test;
        }
        @Override
        public void run() {
            add();
        }
    }

    class MinusThread extends Thread {
        ThreadTest1 test;

        public MinusThread(ThreadTest1 test) {
            this.test = test;
        }

        @Override
        public void run() {
            minus();
        }
    }

}

