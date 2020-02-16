package ConcurrentProgramme;

import java.util.Random;

public class TicketManage {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Station1 station1 = new Station1("第一站",sellTicket);
        Station2 station2 = new Station2("第二站",sellTicket);
        station1.start();
        station2.start();
    }
}

class SellTicket {
     private int count = 100;

    synchronized public void sell(String name) {
        count --;
        System.out.println(name+"卖出一张，还有"+count+"张票");
    }
}

class Station1 extends Thread {
    SellTicket sellTicket;
    String name;
    public Station1(String name,SellTicket sellTicket) {
        this.name = name;
        this.sellTicket = sellTicket;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellTicket.sell(name);

        }

    }
}

class Station2 extends Thread {
    SellTicket sellTicket;
    String name;
    public Station2(String name,SellTicket sellTicket) {
        this.name = name;
        this.sellTicket = sellTicket;
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            sellTicket.sell(name);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
