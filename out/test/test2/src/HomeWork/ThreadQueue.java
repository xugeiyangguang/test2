package HomeWork;

import java.util.concurrent.*;

public class ThreadQueue {
    public static void main(String[] args) {
        queue();
    }

    /***
     * 执行不同的缓存队列
     */
    private static void queue() {
        syncQueue();
       // arrayQueue();
        //linkedQueue();
    }

    /**
     * ArrayBlockingQueue
     */
    private static void arrayQueue() {
        System.out.println("\n\n =======ArrayBlockingQueue====== \n\n");
        Executor executors = new ThreadPoolExecutor(
                2, 3, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                new RejectHandler());
        execute(executors);
    }

    /**
     * LinkedBlockingQueue
     */
    private static void linkedQueue() {
        System.out.println("\n\n =======LinkedBlockingQueue====== \n\n");
        Executor executors = new ThreadPoolExecutor(
                2, 3, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new RejectHandler());
        execute(executors);
    }

    /**
     * SynchronousQueue
     */
    private static void syncQueue() {
        System.out.println("\n\n =======SynchronousQueue====== \n\n");
        Executor executors = new ThreadPoolExecutor(
                2, 3, 30, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new RejectHandler());
        execute(executors);
    }


    //线程池开始工作，放入六个任务到线程池
    private static void execute(Executor executors) {
        executors.execute(new NameRunnable(1));
        executors.execute(new NameRunnable(2));
        executors.execute(new NameRunnable(3));
        executors.execute(new NameRunnable(4));
        executors.execute(new NameRunnable(5));
        executors.execute(new NameRunnable(6));
    }

    /***
     * 创建一个有名字的runnable对象
     */
    private static class NameRunnable implements Runnable {
        private int name;

        public NameRunnable(int name) {
            this.name = name;
        }

        public int getName() {
            return name;
        }

        @Override
        public void run() {
        System.out.println(name + " is running... ");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " is end !!! ");
    }
}

    /***
     * 拒绝的Runnable
     */
    private static class RejectHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            NameRunnable name = (NameRunnable) r;

            System.out.print(name.getName() + " is rejected ^^\n");
        }
    }
}

