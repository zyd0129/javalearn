package demo.basic.interupt;

public class InteruptTest {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (true) {
                if(Thread.currentThread().isInterrupted()){
                    break;
                }
                System.out.println("hello");
            }
        });

        thread.start();

        Thread.sleep(500);

        thread.interrupt();


    }
}
