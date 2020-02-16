package NetProgramme.CStest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws IOException {
        //创建一个ServerSocket用于监听客户端Socket的链接请求
        ServerSocket serverSocket = new ServerSocket(30000);
        //采用不断循环的方式监听来自客户端的请求
        while (true) {
            //每当接收客户端的请求时，服务器端也对应产生一个Socket
            Socket s = serverSocket.accept();
            //创建服务器端Socket的输入流，读取用户传过来的数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //创建服务器端Socket的输出流
            PrintStream printStream = new PrintStream(s.getOutputStream());
            String content = null;
            //将读取的数据不断通过Socket输出流传送给用户
            while ((content = reader.readLine()) != null) {
                printStream.println(content);
            }
            System.out.println("客户端已经退出！");
        }
    }
}
