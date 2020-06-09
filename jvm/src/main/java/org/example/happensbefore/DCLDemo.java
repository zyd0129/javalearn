package org.example.happensbefore;

import java.util.concurrent.atomic.AtomicInteger;

public class DCLDemo {
    private static volatile DCLDemo instance;
    private static AtomicInteger a = new AtomicInteger(5);

    private DCLDemo() {

    }

    /**
     * 锁的粒度
     * 指令重排
     * @return
     */
    public static DCLDemo getInstance() {
        if (instance == null) {
            a.getAndIncrement();
            synchronized (DCLDemo.class) {
                if (instance == null) {
                    /**
                     * 1. new
                     * 2. init
                     * 3. 复制
                     * 2可能放在3后面， 加上volatile， 3之前加读屏障，3之前的指令不会发生在3后面
                     */
                    instance = new DCLDemo();
                }
            }
        }
        return instance;
    }
}
