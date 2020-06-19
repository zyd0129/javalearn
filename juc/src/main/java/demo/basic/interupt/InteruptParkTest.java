package demo.basic.interupt;

import java.util.concurrent.locks.LockSupport;

public class InteruptParkTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("before park");

            LockSupport.park();

            System.out.println("after park");

        });

        thread.start();

        Thread.sleep(1000);

        thread.interrupt();
    }
}
