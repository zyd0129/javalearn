package demo.juc.reentra;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLockTest {
}

//自定义锁，不可重入
class MyLock implements Lock{


    //独占锁
    class  MySync extends AbstractQueuedSynchronizer{

        //不可重入
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                //加上锁
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);  //放在后面,state是volatile, exclusiveOwnerThread不是
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1 && getExclusiveOwnerThread().equals(Thread.currentThread());
        }

        public  Condition newCondition() {
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();



    //加锁，不成功进入等待队列
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    //一次加锁
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        // 会去唤醒
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
