package bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8080);

        Scanner scanner = new Scanner(System.in);

        String next = scanner.next();
        while (!next.equals("quit")) {
            socket.getOutputStream().write(next.getBytes());

            System.out.println("please input data:");
            next = scanner.next();
        }
        socket.close();
    }
}
