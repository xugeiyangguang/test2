package ConcurrentProgramme;

public class ParkCarMyself {
    public static void main(String[] args) {
        Park1 park1 = new Park1();

        User1 u1 = new User1(park1);
        User1 u2 = new User1(park1);
        User1 u3 = new User1(park1);
        User1 u4 = new User1(park1);

        u1.start();
        u2.start();
        u3.start();
        u4.start();

        try {
            u1.join();
            u2.join();
            u3.join();
            u4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("停车总计：" + park1.parkNum);
        System.out.println("离开总计：" + park1.leaveNum);
    }
}

class Park1{
    boolean[] position = new boolean[3];
    public Park1(){

    }
    int parkNum = 0;
    int leaveNum = 0;

    //停车
    public synchronized void park() throws InterruptedException {
        while (isFull()){
            this.wait();
        }
        for (int i = 0; i < position.length; i++){
            if (position[i] == false){
                position[i] = true;
                break;
            }
        }
        parkNum++;
        show();
    }
    //离开空出车位
    public synchronized void leave(){
        for (int i = 0; i < position.length; i++){
            if (position[i] == true){
                position[i] = false;
                break;
            }
        }
        notifyAll();
        leaveNum++;
        show();
    }
    //停车场是否是满的
    public boolean isFull(){
        boolean flag = true;
        for (boolean i:position
             ) {
            if (i == false){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void show(){
        for( boolean place : position ){
            System.out.print(place + " ");
        }
        System.out.println();
    }

}

class User1 extends Thread{
        Park1 park1;
    public User1(Park1 park1){
            this.park1 = park1;
        }
        public void run(){
        for (int i = 0; i < 2; i ++){
            try {
                park1.park();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            park1.leave();
        }


    }
}
