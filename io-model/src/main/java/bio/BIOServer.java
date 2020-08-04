package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            System.out.println("wait con...");
            Socket clientSocket = serverSocket.accept();
            /**
             * 连接成功了，也发送过去了，但是服务器上的应用还没有处理
             */
            System.out.println("con success");
            InputStream inputStream = clientSocket.getInputStream();
            byte[] bt = new byte[1024];
            int len;
            while ((len=inputStream.read(bt)) != -1) {
                System.out.println("receive data:");
                System.out.println(new String(bt,0,len));
            }
        }
    }
}
