package demo.basic;

public class SynchronizedTest {

    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> resource.increment()).start();
        new Thread(() -> resource.decrement()).start();
    }

    private static class Resource {
        int count;

        public synchronized void increment() {
            count++;
        }

        public synchronized void decrement() {
            count--;
        }
    }
}
