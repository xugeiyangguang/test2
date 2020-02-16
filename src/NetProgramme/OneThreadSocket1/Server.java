package NetProgramme.OneThreadSocket1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
            Socket s = serverSocket.accept();
            PrintStream printStream = new PrintStream(s.getOutputStream());
            printStream.println("新年快乐！");
            printStream.close();
            s.close();
        }
    }
}
