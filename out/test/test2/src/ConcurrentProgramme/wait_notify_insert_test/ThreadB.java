package ConcurrentProgramme.wait_notify_insert_test;

public class ThreadB extends Thread {
    private DBTools dbTools;

    public ThreadB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dbTools.backupB();
    }
}
