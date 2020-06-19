package demo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {

    }

    public static class MyCache{
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Map<String, String> data = new HashMap<>();

        public String get(String index) {
            String result;
            lock.readLock().lock();
            try{
               result = data.get(index);
            }finally {
                lock.readLock().unlock();
            }
            return result;
        }

        public void put(String key, String value) {
            lock.writeLock().lock();
            try{
                data.put(key, value);
            }finally {
                lock.readLock().unlock();
            }
        }
    }
}
