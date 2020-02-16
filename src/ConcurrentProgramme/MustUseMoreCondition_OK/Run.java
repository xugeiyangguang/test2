package ConcurrentProgramme.MustUseMoreCondition_OK;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("使用value对hashMap排序");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        service.signalALL_A();
    }
}
