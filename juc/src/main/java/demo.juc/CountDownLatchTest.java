package demo.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int j=i;
            new Thread(()-> {
                System.out.println("i=" + j);
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("end");
    }
}
