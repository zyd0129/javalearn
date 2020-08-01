package nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * BIO如果要支持并发，因为read是阻塞的，必须每个连接开多线程；但同一时间有的线程是空闲的，也就是阻塞的，造成多线程资源浪费
 */
public class NIOServer {
    public static void main(String[] args) {

        List<SocketChannel> socketChannelList = new ArrayList<>();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8090);
            serverSocketChannel.bind(socketAddress);
            serverSocketChannel.configureBlocking(false);
            while (true) {
                SocketChannel accept = serverSocketChannel.accept();
                //如果socketChannel没有数据，这里还是会空循环； select和epoll就是为了解决这个问题
                // 怎么讲list给操作系统
                // windows 提供selector
                // linux 提供epoll
                //
                for (SocketChannel socketChannel : socketChannelList) {
                    int read = socketChannel.read(byteBuffer);
                    if (read > 0) {
                        byteBuffer.flip();
                        byte[] bt = new byte[read];
                        byteBuffer.get(bt);
                        System.out.println(new String(bt));
                        byteBuffer.flip();
                    }
                }
                if (accept != null) {
                    accept.configureBlocking(false);
                    socketChannelList.add(accept);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
