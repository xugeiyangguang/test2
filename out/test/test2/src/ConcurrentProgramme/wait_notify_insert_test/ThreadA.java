package ConcurrentProgramme.wait_notify_insert_test;

public class ThreadA extends Thread {
    private DBTools dbTools;

    public ThreadA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}
