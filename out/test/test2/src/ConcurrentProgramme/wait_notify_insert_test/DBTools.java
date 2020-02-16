package ConcurrentProgramme.wait_notify_insert_test;

public class DBTools {
    private boolean preIsA = true;

    synchronized public void backupA() {
        try {
            while (preIsA == false) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print("a");
            }
            System.out.println();
            preIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB() {
        try {
            while (preIsA == true) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print("b");
            }
            System.out.println();
            preIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
