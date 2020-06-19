package demo.juc;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    private StampedLock lock;

    public static void main(String[] args) {

    }

    public void read(){
        long stamp = lock.tryOptimisticRead();
        //进行读操作
        if (lock.validate(stamp)) {
            //如果戳没发生变化，返还数据
            return;
        }

        stamp = lock.readLock();

        try{

        }finally {
            lock.unlockRead(stamp);
        }
    }

    public void write() {
        long stamp = lock.writeLock();

        try{

        }finally {
            lock.unlockWrite(stamp);
        }

    }
}
