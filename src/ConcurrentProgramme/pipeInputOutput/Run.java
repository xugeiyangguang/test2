package ConcurrentProgramme.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();

        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream();

        try {
            //管道链接
            outputStream.connect(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
        threadWrite.start();

        Thread.sleep(2000);
        ThreadRead threadRead = new ThreadRead(readData, inputStream);
        threadRead.start();

    }
}
