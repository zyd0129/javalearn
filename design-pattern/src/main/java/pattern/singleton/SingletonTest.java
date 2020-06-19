package pattern.singleton;

public class SingletonTest {
}

/**
 * 饿汉式 静态变量
 * 在类加载的时候，实例化单例对象，使用类的加载机制，保证多线程安全
 */

class SingletonHungry1 {

    private static SingletonHungry1 instance = new SingletonHungry1();

    private SingletonHungry1() {
    }

    public SingletonHungry1 getInstance() {
        return instance;
    }
}

class SingletonHungry2 {

    private static SingletonHungry2 instance;

    static {
        instance = new SingletonHungry2();
    }

    private SingletonHungry2() {
    }

    public SingletonHungry2 getInstance() {
        return instance;
    }
}

/**
 * 懒汉式
 */

class SingletonHungry3 {

    private static SingletonHungry3 instance;

    private SingletonHungry3() {
    }

    //  线程不安全

//    public SingletonHungry3 getInstance() {
//        if (instance == null) {
//            instance = new SingletonHungry3();
//        }
//        return instance;
//    }

//    /*
//    线程安全，每次获取都要加锁，效率低
//     */
//    public synchronized SingletonHungry3 getInstance() {
//        if (instance == null) {
//            instance = new SingletonHungry3();
//        }
//        return instance;
//    }

    /*
    double check,还是有问题，new SingletonHungry3();是多条指令，存在指令重排
     */
    public SingletonHungry3 getInstance() {
        if (instance == null) {
            synchronized (SingletonHungry3.class) {
                if (instance == null) {
                    instance = new SingletonHungry3();
                }
            }
        }
        return instance;
    }
}

class SingletonHungry4 {

    // volatile禁止指令重排

    private static volatile SingletonHungry4 instance;

    private SingletonHungry4() {
    }

    /*
    double check,还是有问题，new SingletonHungry3();是多条指令，存在指令重排
     */
    public SingletonHungry4 getInstance() {
        if (instance == null) {
            synchronized (SingletonHungry3.class) {
                if (instance == null) {
                    instance = new SingletonHungry4();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类
 */
class SingletonHungry5 {


    static class SingletonInstance {
        private static SingletonHungry5 instance = new SingletonHungry5();
    }

    private SingletonHungry5() {
    }

    public SingletonHungry5 getInstance() {
        return SingletonInstance.instance;
    }
}

/**
 * 枚举类，线程安全，且防止序列化
 */
enum  SingletonEnum{
    INSTANCE;
    public void say(){
        System.out.println("hello");
    }
}

/**
 * 使用场景，工具类，线程池等
 * Runtime类是一个单例类，
 * 保证只有一个实例，避免他人错误创建
 */