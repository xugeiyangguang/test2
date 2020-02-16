package ConcurrentProgramme.singleton.DCLDoubleCheck;

import ConcurrentProgramme.singleton.quickLoad.MyObject;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject3.INSTANCE.hashCode());
    }
}
