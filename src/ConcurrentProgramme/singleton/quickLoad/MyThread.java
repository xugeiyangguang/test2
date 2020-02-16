package ConcurrentProgramme.singleton.quickLoad;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
