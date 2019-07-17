package BaseJava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @Author: egg
 * @Date: 2019-06-25 20:36
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    /**
     * 1。创建ServerSocket对象，绑定监听端口
     * 2。通过accept()方法监听客户端请求
     * 3。通过输入流接收客户端发来的信息
     * 4。通过输出流向客户端发送响应信息
     * @param port
     * @throws IOException
     */

    public GreetingServer(int port) throws IOException
    {
        //服务器实例化serverSocket
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }
    public static void main(String [] args)
    {
        int port = Integer.parseInt(args[0]);
        try
        {
            Thread t = new GreetingServer(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
