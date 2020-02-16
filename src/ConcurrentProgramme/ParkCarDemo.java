package ConcurrentProgramme;

//建立Park类表示停车场，作为同步监听器
class Park {

    boolean[] cars;

    //用于统计数据
    int parkTotal;
    int leaveTotal;

    public Park(){
        cars = new boolean[3];
    }

    public synchronized void park(){
        //此处一定要用while不能用if，因为可能需要反复争抢
        while ( isFull() ){
            myWait();
        }

        //停车
        cars[getOneEmpty()] = true;

        parkTotal++;

        show();
    }

    public synchronized void leave(){
        //空出车位
        cars[getOneCar()] = false;

        this.notifyAll();

        leaveTotal++;

        show();
    }

    //停车场是否是满的
    private boolean isFull(){
        boolean flag = true;
        for ( boolean place : cars ){
            if ( !place ){
                flag = false;
                break;
            }
        }
        return flag;
    }

    //得到一个空位
    private int getOne(boolean flag){
        int i = 0;
        for ( ; i < cars.length; i++ ){
            if ( cars[i] == flag ){
                return i;
            }
        }

        return -1;
    }

    //得到一个空车位的索引
    private int getOneEmpty(){
        return getOne(false);
    }

    //得到一个有车的车位的索引
    private int getOneCar(){
        return getOne(true);
    }

    private void myWait() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new  RuntimeException();
        }
    }

    private void show(){
        for( boolean place : cars ){
            System.out.print(place + " ");
        }
        System.out.println();
    }

    public int getParkTotal() {
        return parkTotal;
    }

    public int getLeaveTotal() {
        return leaveTotal;
    }
}

class User extends Thread {
    Park park;

    public User(Park park) {
        this.park = park;
    }

    @Override
    public void run() {
        for ( int i = 0; i < 10; i++ ){
            park.park();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            park.leave();
        }
    }
}

public class ParkCarDemo {

    public static void main(String[] args) {
        Park park = new Park();

        User u1 = new User(park);
        User u2 = new User(park);
        User u3 = new User(park);
        User u4 = new User(park);
        User u5 = new User(park);
        User u6 = new User(park);
        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
        u6.start();

        try {
            u1.join();
            u2.join();
            u3.join();
            u4.join();
            u5.join();
            u6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("停车总计：" + park.getParkTotal());
        System.out.println("离开总计：" + park.getLeaveTotal());

    }

}



