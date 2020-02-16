package ConcurrentProgramme;

public class Run2 {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        myThread.start();

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            System.out.println("main catch!");
            e.printStackTrace();
        }
        myThread.interrupt();
        System.out.println("end!");
    }
}
