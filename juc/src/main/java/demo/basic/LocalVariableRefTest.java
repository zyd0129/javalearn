package demo.basic;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableRefTest {

    public static class Resource{
        public void method1() {
            List a = new ArrayList();
            method2(a);
            method3(a);
        }

        private void method3(List a) {
            a.add("1");
        }

        private void method2(List a) {
            new Thread(() -> a.remove(0)).start();
        }
    }
}
