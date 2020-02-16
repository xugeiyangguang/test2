package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOBuffer {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\java_work\\src\\IO\\content.txt");
        FileChannel fc = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("初始化：", buffer);

        fc.read(buffer);
        output("读完后：", buffer);

        buffer.flip();
        output("flip后：", buffer);

        buffer.clear();
        output("clear后：", buffer);

    }

    public static void output(String step, Buffer buffer) throws IOException {
        System.out.print("Buffer position:" + buffer.position());
        System.out.print("Buffer limit:" + buffer.limit());
        System.out.println("Buffer capacity:" + buffer.capacity());
    }
}
