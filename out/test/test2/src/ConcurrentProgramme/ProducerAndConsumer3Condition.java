package ConcurrentProgramme;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer3Condition {
    public static void main(String[] args) {
        Storage3 storage3 = new Storage3();

        for (int i = 0; i < 6; i++){
            int finalI = i;
            new Thread(()->storage3.push("生产者"+finalI)).start();
        }

        for (int j = 0; j < 6; j++){
            int finalI = j;
            new Thread(()->storage3.poll("消费者"+finalI)).start();
        }
    }
}
class Storage3{
    int count = 0; //容量为5
    final static Lock key = new ReentrantLock();  //显示锁
    final static Condition full = key.newCondition();   //两种不同状态的Condition实例
    final static Condition empty = key.newCondition();
    public void push(String producer){
        key.lock();
        try{
            while (count == 5){
                System.out.println("容器已满，"+producer+"生产者阻碍！");
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;   //增加一个产品
            System.out.println("生产者"+producer+"生产一个产品！现在容器中有"+count +"个产品");
            empty.signalAll(); //唤醒其他消费者线程
        }finally {
            key.unlock();
        }

    }

    public void poll(String consumer){
        key.lock();
        try{
            while (count == 0){
                System.out.println("容器为空，消费者"+consumer+"阻碍！");
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println("消费者"+consumer+"消费一个产品!现在容器中有"+count +"个产品");
            full.signalAll();
        }finally {
            key.unlock();
        }

    }
}
