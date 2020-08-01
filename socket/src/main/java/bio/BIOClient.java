package bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9098);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String next = scanner.next();
                socket.getOutputStream().write(next.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
