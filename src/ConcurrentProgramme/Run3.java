package ConcurrentProgramme;

public class Run3 {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        long begintime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
            count += i;
        }
        long endtime = System.currentTimeMillis();
        System.out.println("用时" + (endtime - begintime));
    }
}
