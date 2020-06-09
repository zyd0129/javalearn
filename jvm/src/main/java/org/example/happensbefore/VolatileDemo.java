package org.example.happensbefore;

public class VolatileDemo {
    public static void main(String[] args) {

        final VolatileObj obj = new VolatileObj();

        Thread thread1 = new Thread(()->{
            obj.write();
        });

        Thread thread2 = new Thread(()-> obj.read());

    }

    public static class VolatileObj {

        int i = 0;
        volatile boolean flag = false;

        //Thread A
        public void write(){
            i = 2;              //1
            flag = true;        //2
        }

        //Thread B
        public void read(){
            if(flag){                                   //3
                System.out.println("---i = " + i);      //4
            }
        }
    }
}
