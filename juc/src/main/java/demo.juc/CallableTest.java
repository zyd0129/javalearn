package demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyCallable());
        new Thread(futureTask).start();
        Integer a = (Integer) futureTask.get();

    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return null;
        }
    }

}
