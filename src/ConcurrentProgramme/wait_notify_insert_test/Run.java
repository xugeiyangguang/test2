package ConcurrentProgramme.wait_notify_insert_test;

public class Run {
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();


        for (int i = 0; i < 20; i++) {
            ThreadA threadA = new ThreadA(dbTools);
            threadA.start();
            ThreadB threadB = new ThreadB(dbTools);
            threadB.start();
        }
    }
}
