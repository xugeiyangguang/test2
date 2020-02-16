package ConcurrentProgramme;

import NetProgramme.MultiThread.server.Myserver;

public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("myThread");
        myThread.start();
        for (int i = 0; i < 5; i++) {
            int time = (int) (Math.random() * 1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run=" + Thread.currentThread().getName());
        }

    }


}

class MyThread extends Thread {
    @Override
    public void run() {
       // super.run();
        for (int i = 0; i < 5; i++) {
            int time = (int) (Math.random() * 1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main=" + Thread.currentThread().getName());
        }
    }
}
