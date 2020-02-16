package ConcurrentProgramme.changeLock;

public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();
        threadA.setName("使用value对hashMap排序");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadB threadB = new ThreadB(myService);
        threadB.setName("B");
        threadB.start();

    }
}
