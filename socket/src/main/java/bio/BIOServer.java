package bio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO如果要支持并发，因为read是阻塞的，必须每个连接开多线程；但同一时间有的线程是空闲的，也就是阻塞的，造成多线程资源浪费
 */
public class BIOServer {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(9098);
            while (true) {
                System.out.println("wait conn...");
                Socket clientSocket = serverSocket.accept(); //阻塞
                System.out.println("conn success");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] bs = new byte[1024];
                        while (true){
                            System.out.println("wait data:");
                            try {
                                clientSocket.getInputStream().read(bs);//阻塞
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                            System.out.println("get data:");
                            System.out.println(new String(bs));
                        }

                    }
                }).start();

//                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
