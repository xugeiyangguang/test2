package ConcurrentProgramme.ConditionProducer_Customer;

public class Run {
    public static void main(String[] args) {
        Myservice myservice = new Myservice();
        for (int i = 0; i < 5; i++) {
            ThreadProducer producer = new ThreadProducer(myservice);
            producer.start();
            ThreadConsuer consuer = new ThreadConsuer(myservice);
            consuer.start();
        }

    }
}
