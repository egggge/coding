package BaseJava;

import java.io.*;
import java.net.Socket;

/**
 * @Author: egg
 * @Date: 2019-06-25 20:35
 */
public class GreetingClient {
    /**
     * 创建客户端socket对象，指明需要连接的ip地址和端口号
     * 通过输出流向服务器发送请求信息
     * 通过输入流接受服务器发送过来的信息
     * @param args
     */
    public static void main(String [] args)
    {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try
        {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            //创建socket对象，指明服务器的地址和端口号
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            //通过输出流OutputStream向服务器发送请求信息
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
