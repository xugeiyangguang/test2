package ConcurrentProgramme.ConditionProducer_Customer;

import ConcurrentProgramme.MustUseMoreCondition_OK.MyService;

public class ThreadProducer extends Thread {
    private Myservice myservice;

    public ThreadProducer(Myservice myservice) {
        this.myservice = myservice;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            myservice.set();
        }

    }
}
