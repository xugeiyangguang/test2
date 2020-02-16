package NetProgramme.OneThreadSocket1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",30010);
        Scanner scanner = new Scanner(socket.getInputStream());
        String line = scanner.nextLine();
        System.out.println("来自服务器的数据："+line);
        socket.close();
    }
}
