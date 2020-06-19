package demo.juc.reentra;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {

            if (!lock.tryLock()) return;


            try {

            } finally {
                lock.unlock();
            }
        }).start();
    }
}
