package NetProgramme.MultiThread.server;

import NetProgramme.OneThreadSocket.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Myserver
{
    // 定义保存所有Socket的ArrayList，并将其包装为线程安全的
    public static List<Socket> socketList
            = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args)
            throws IOException
    {
        ServerSocket ss = new ServerSocket(30000);
        while(true)
        {
            // 此行代码会阻塞，将一直等待别人的连接
            Socket s = ss.accept();
            socketList.add(s);
            // 每当客户端连接后启动一条ServerThread线程为该客户端服务
            new Thread(new ServerThread(s)).start();
        }
    }
}

