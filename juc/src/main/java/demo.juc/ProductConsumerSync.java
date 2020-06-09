package demo.juc;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ProductConsumerSync {
    public static void main(String[] args) {
        Data data = new Data();  //  资源
        int j=5;

//        CopyOnWriteArrayList
        //线程操作资源
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(j);
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
//        j=6;

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

        public synchronized void increment() throws InterruptedException {
            /*
            如果使用if,存在虚假唤醒的问题，
            wait() 会释放锁，被唤醒时，重新获得锁
             */
            while (i >= 1) {
                System.out.println(Thread.currentThread().getName() + "->wait");
                wait();
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "->" + i);
            notifyAll();
        }

        public synchronized void decrement() throws InterruptedException {
            while (i == 0) {
                System.out.println(Thread.currentThread().getName() + "->wait");
                wait();
            }
            i--;
            System.out.println(Thread.currentThread().getName() + "->" + i);
            notifyAll();
        }
    }
}
