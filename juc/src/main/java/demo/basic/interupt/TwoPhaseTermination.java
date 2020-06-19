package demo.basic.interupt;

import java.util.concurrent.TimeUnit;

public class TwoPhaseTermination {

    private Thread monitor;

    public void start() {
        monitor = new Thread(()->{
            Thread cur = Thread.currentThread();
            while (true) {
                System.out.println("执行监控");
                if (cur.isInterrupted()) {
                    //执行善后
                    System.out.println("执行善后");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    cur.interrupt();
                }
            }
        });
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}
