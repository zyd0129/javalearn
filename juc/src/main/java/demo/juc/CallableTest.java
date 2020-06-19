package demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask把异常信息赋值给outcome，并将state设为EXCEPTIONAL。
 * 在调用get()时，如果运行时抛出异常，此时会抛出异常。
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        try {
            Integer a = (Integer) futureTask.get();
            System.out.println(a);
        } catch (Exception e) {
            //捕获异常
        }

    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return 2;
        }
    }

}
