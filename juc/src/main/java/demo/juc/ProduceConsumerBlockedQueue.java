package demo.juc;

import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceConsumerBlockedQueue {
    public static void main(String[] args) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        Iterator iterator = linkedBlockingDeque.iterator();

        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
        arrayList.iterator();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }

    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<Integer> blockingQueue;

    public void produce(){
        while (FLAG) {
            blockingQueue.offer(atomicInteger.getAndIncrement());
        }
    }

    public void consume() throws InterruptedException {
        while (FLAG) {
            Integer ret = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (ret == null) {
                FLAG = false;
            }
        }
    }

    public void stop() {
        FLAG = false;
    }
}
