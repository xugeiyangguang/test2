package ConcurrentProgramme;

import java.util.LinkedList;

public class ProducerAndConsumer2 {
    public static void main(String[] args) {
        Storage2 storage2 = new Storage2();
        //开启生产者线程
        for (int i = 0;i < 6; i++){
            int finalI = i;
            new Thread(()-> storage2.produce2(String.format("生产者%d",finalI))).start();
        }

        //开启消费者线程
        for (int i = 0; i < 5; i++){
            int finalI = i;
            new Thread(()->storage2.consume2(String.format("消费者%d",finalI))).start();
        }

    }
}

class Storage2{
    //仓库的最大容量
    private final int MAX_SIZE = 100;
    //仓库存储的载体
    private LinkedList<Object> list = new LinkedList<>();

    //生产产品
    public void produce2(String producer){
        synchronized (list){
            while (list.size() == MAX_SIZE){
                System.out.println("仓库已满，【"+producer+"】：暂时不能执行生产任务！");
                try {
                    //由于条件不满足，生产阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("生产者"+producer+"生产了一个产品");
            list.notifyAll();
        }
    }

    //消费产品
    public void consume2(String consumer){
        synchronized (list){
            while (list.size() == 0){
                System.out.println("仓库已空，【"+consumer+"】：暂时不能执行消费任务！");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("消费者"+consumer+"消费了一个产品！");
            list.notifyAll();
        }
    }
}