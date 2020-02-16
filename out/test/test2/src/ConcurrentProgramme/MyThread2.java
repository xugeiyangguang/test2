package ConcurrentProgramme;

/**
 * 采用interrupt并不能让线程立即停止，需要用interrupted来检测，
 * 检测之后要抛出InterruptedException异常，才能使得线程不继续执行**/
public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("已经是停止状态了！我要退出了！");
                    throw new InterruptedException();
                }
                System.out.println("i=" + i);
            }
            System.out.println("我在for下面！");  //没有执行
        } catch(InterruptedException e) {
            System.out.println("进入MyThread.java类run方法中的catch了！");
            e.printStackTrace();
        }


    }
}
