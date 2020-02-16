package ConcurrentProgramme.ConditionProducer_Customer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Myservice {
    private Lock lock = new ReentrantLock();
    public Condition Con_producer = lock.newCondition();
    public Condition Con_customer = lock.newCondition();
    public boolean has_Value = false;
    public void get() {
        try {
            lock.lock();
            while (has_Value == false) {
                System.out.println("有可能消费者连续阻塞");
                Con_customer.await();
            }
            System.out.println("消费者消费一个");
            has_Value = false;
            Con_producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void set() {
        try {
            lock.lock();
            while (has_Value == true) {
                System.out.println("有可能生产者连续阻塞");
                Con_producer.await();
            }
            System.out.println("生产者生产一个");
            has_Value = true;
            Con_customer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
