package ConcurrentProgramme;

import java.util.concurrent.LinkedBlockingQueue;


public class ProducerAndConsumer4BlockQueue {
    public static void main(String[] args) {
        Storage4 storage4 = new Storage4();

        for (int i = 0; i < 6; i++){
            int finalI = i;
            new Thread(()->storage4.push("生产者"+finalI)).start();
        }

        for (int j = 0; j < 6; j++){
            int finalI = j;
            new Thread(()->storage4.poll("消费者"+finalI)).start();
        }

        /*Producer4 p = new Producer4(storage4);
        Consumer4 s = new Consumer4(storage4);
        p.start();
        s.start();*/
    }
}

class Producer4 extends Thread{
    private Storage4 storage4;
    public Producer4(Storage4 storage4){
        this.storage4 = storage4;
    }
    public void run(){
        for (int i = 0; i < 6;i++){
            storage4.push("生产者");
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}

/*class Consumer4 extends Thread{
    private Storage4 storage4;
    public Consumer4(Storage4 storage4){
        this.storage4 = storage4;
    }
    public void run(){
        for (int i = 0; i < 6;i++){
            storage4.poll("消费者");
        }
    }
}*/
class Storage4{
    private final int MAX_SIZE = 100;
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(100);
    public void push(String producer){
        if (list.size() == MAX_SIZE ){
            System.out.println("容器已满，"+producer+"生产者阻碍！");
        }

        try {
            list.put(new Object());
            //在读大小的时候有脏数据？？？？
            System.out.println("生产者"+producer+"生产一个产品！现在容器中有"+(list.size()-1)+"个产品");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public void poll(String consumer){
        if (list.size() == 0){
            System.out.println("容器为空，消费者"+consumer+"阻碍！");
        }

        try {
            list.take();
            System.out.println("消费者"+consumer+"消费一个产品!现在容器中有"+(list.size()-1) +"个产品");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}