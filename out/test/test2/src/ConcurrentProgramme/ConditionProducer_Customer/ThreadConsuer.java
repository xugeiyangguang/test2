package ConcurrentProgramme.ConditionProducer_Customer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;


public class ThreadConsuer extends Thread {
    private Myservice myservice;

    public ThreadConsuer(Myservice myservice) {
        this.myservice = myservice;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            myservice.get();
        }

    }
}