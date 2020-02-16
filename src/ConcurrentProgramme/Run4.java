package ConcurrentProgramme;

class SynLockIn {
    int i = 10;

    public void operateMainMethod() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sub extends SynLockIn {
    synchronized public void operateISubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i= " + i);
                Thread.sleep(100);
                this.operateMainMethod();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        super.run();
        Sub sub = new Sub();
        sub.operateISubMethod();
    }
}

public class Run4{
    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();
        myThread4.start();
    }
}
