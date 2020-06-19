package demo.juc.reentra;

import java.util.concurrent.locks.ReentrantLock;

public class InteruptLockTest {
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

            try{

            }finally {
                lock.unlock();
            }
        }).start();
    }
}
