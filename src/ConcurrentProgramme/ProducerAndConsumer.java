package ConcurrentProgramme;

public class ProducerAndConsumer{
    public static void main(String[] args) {
        Storage1 storage1 = new Storage1();

        for (int i = 0; i < 6; i++){
            int finalI = i;
            new Thread(()->storage1.push("生产者"+finalI)).start();
        }

        for (int j = 0; j < 6; j++){
            int finalI = j;
            new Thread(()->storage1.poll("消费者"+finalI)).start();
        }
    }
}
class Storage1{
    int count = 0; //容量为5
    Object lock = new Object();//同步监视器
    public void push(String producer){
        synchronized (lock){
            while (count == 5){
                System.out.println("容器已满，"+producer+"生产者阻碍！");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;   //增加一个产品
            System.out.println("生产者"+producer+"生产一个产品！");
            lock.notifyAll(); //唤醒其他消费者线程
        }
    }

    public void poll(String consumer){
        synchronized (lock){
            while (count == 0){
                System.out.println("容器为空，消费者"+consumer+"阻碍！");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println("消费者"+consumer+"消费一个产品!");
            lock.notifyAll();
        }
    }
}
