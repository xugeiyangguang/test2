package ConcurrentProgramme.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
    public void readData(PipedInputStream inputStream) {
        try {
            System.out.println("read:");
            byte[] byteArray = new byte[20];
            int readLength = inputStream.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = inputStream.read(byteArray);
            }
            System.out.println();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
