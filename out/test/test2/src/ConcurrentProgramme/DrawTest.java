package ConcurrentProgramme;

public class DrawTest {
    public static void main(String[] args) {
        Count count = new Count();
        SaveThread saveThread = new SaveThread(count);
        DrawThread drawThread = new DrawThread(count);
        saveThread.start();
        drawThread.start();


    }
}

class Count {
    int hasmoney = 0;

    public synchronized void save() {
        while (hasmoney == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasmoney = 1;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()+"存钱！");

    }

    public synchronized void draw() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hasmoney = 0;
        notifyAll();
        System.out.println(Thread.currentThread().getName()+"取钱！");
    }
}

class SaveThread extends Thread {
    Count count;

    public SaveThread(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            count.save();
        }

    }
}

class DrawThread extends Thread {
    Count count;

    public DrawThread(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count.draw();
        }

    }
}