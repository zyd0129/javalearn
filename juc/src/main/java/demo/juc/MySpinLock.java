package demo.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 锁就是一个标志位
 */

public class MySpinLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();

        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null); //原子操作
    }
}
