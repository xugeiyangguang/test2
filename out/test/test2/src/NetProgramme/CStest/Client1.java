package NetProgramme.CStest;

import ConcurrentProgramme.NotifyUntil5.Run;
import NetProgramme.MultiThread.Client.ClientThread;
import NetProgramme.OneThreadSocket.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Hashtable;

public class Client1 {
    public static void main(String[] args) throws IOException {
        //创建客户端的Socket
        Socket s = new Socket("127.0.0.1", 30000);
        //启动显示服务器端推送的内容的进程
        new Thread(new ClientThread1(s)).start();
        //建立读取键盘输入的输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //建立客户端Socket的输出流
        PrintStream printStream = new PrintStream(s.getOutputStream());
        //保存键盘获取的内容
        String content = null;
        //不断将键盘获取的内容加入到建立的Socket中
        while ((content = reader.readLine()) != null) {
            //当输入是“end”的时候，关闭客户端的Socket
            if (content.equals("end")) {
                s.close();
            }
            printStream.println(content);
        }
    }
}
//
class ClientThread1 implements Runnable {
    Socket s;
    BufferedReader reader = null;


    public ClientThread1(Socket s) throws IOException {
        this.s = s;
        //获取客户端Socket的输入流
        reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run() {
        try {
            String str = null;
            //读取服务端中传来的数据
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("停止输入1");
        }

    }
}
