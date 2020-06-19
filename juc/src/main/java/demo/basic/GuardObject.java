package demo.basic;

public class GuardObject {
    private Object response;


    public Object get() {
        synchronized (this) {
            while (response == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public Object get(long timeout) {
        long begin = System.currentTimeMillis();
        long passedTime = 0;
        synchronized (this) {
            while (response == null) {
                long waitedTime = timeout - passedTime;
                if (waitedTime <= 0) break;
                try {
                    wait(waitedTime); //要考虑虚假唤醒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }

    public void complete(Object response) {
        this.response = response;
        notifyAll();
    }
}
