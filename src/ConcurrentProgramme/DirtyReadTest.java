package ConcurrentProgramme;

public class DirtyReadTest {
    public static void main(String[] args) {
        PublicVar publicVar = new PublicVar();
        ThreadA threadA = new ThreadA(publicVar);
        threadA.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publicVar.getValue();
    }
}

class ThreadA extends Thread {
    PublicVar publicVar = new PublicVar();

    public ThreadA(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("b","bb");
    }
}
class PublicVar {
    public String name = "使用value对hashMap排序";
    public String keyWord = "AA";

    synchronized public void setValue(String name, String keyWord) {
        this.name = name;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.keyWord = keyWord;
        System.out.println(Thread.currentThread().getName() + ",name=" + name + ", keyword=" + keyWord);

    }

    synchronized public void getValue() {
        System.out.println(Thread.currentThread().getName() + ",name=" + name + ", keyword=" + keyWord);
    }
}
