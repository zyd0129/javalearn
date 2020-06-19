package pattern.singleton;

import java.io.*;

public class SingletonSerializeTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton singleton = Singleton.instance;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singletonSerialize"));
        objectOutputStream.writeObject(singleton);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singletonSerialize"));

        Singleton o = (Singleton) objectInputStream.readObject();

        System.out.println(singleton.equals(o));

    }

    static class Singleton implements Serializable {
        static final long serialVersionUID = 42L;

        private static Singleton instance = new Singleton();

        private Singleton() {

        }

        public Singleton getInstance() {
            return instance;
        }

        Object readResolve() {
            return Singleton.instance;
        }
    }
}

