package demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized与 lock区别
 * 1. synchronized 自动， lock手动释放锁
 * 2. synchronized获取不到锁会阻塞， lock.tryLock()
 * 3. synchronized 非公平锁， lock支持公平锁
 */

public class ProductConsumerLock {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

    public static class Data {
        private int i;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        public void increment() throws InterruptedException {
            try {
                lock.lock();

                while (i >= 1) {
                    System.out.println(Thread.currentThread().getName() + "->wait");
                    condition.await();
                }
                i++;
                System.out.println(Thread.currentThread().getName() + "->" + i);
                condition.signalAll();

            } finally {
                lock.unlock();
            }
        }

        public void decrement() throws InterruptedException {
            try {
                lock.lock();
                while (i == 0) {
                    System.out.println(Thread.currentThread().getName() + "->wait");
                    condition.await();
                }
                i--;
                System.out.println(Thread.currentThread().getName() + "->" + i);
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }
}
