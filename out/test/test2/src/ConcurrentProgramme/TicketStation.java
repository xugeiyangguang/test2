package ConcurrentProgramme;

import java.util.stream.StreamSupport;
//主方法调用类
public class TicketStation {
    public static void main(String[] args) {
        Station s1 = new Station("1");
        Station s2 = new Station("2");
        Station s3 = new Station("3");

        s1.start();
        s2.start();
        s3.start();

    }
}

//站台类
class Station extends Thread{

    public Station(String name){
        super(name);
    }

    //票的总数
    static int ticketNumber = 20;

    //同步监视器
    static Object key = "aaa";

    @Override
    public void run() {
        while (ticketNumber > 0){
            //采用的同步代码块
            synchronized (key){
                if (ticketNumber > 0){    //getName()返回当前线程的名字
                    System.out.println(getName()+"卖了第" + (21-ticketNumber) + "张票！");
                    ticketNumber--;
                }else {
                    System.out.println("票卖完了！");
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
