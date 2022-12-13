package com.threads.server.threadlock.aqs;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 罗泽民
 * @description 基于 AQS 实现的不可重入的独占锁的demo，来自《Java并发编程之美》
 * @date 2022/12/6 17:11
 */
public class NonReentrantLock implements Lock, Serializable {
    //内部类,自定义同步器
    private final Sync sync = new Sync();

    //创建一个Sync来做具体的工作
    @Override
    public void lock() {
        sync.acquire(1);
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    static class Sync extends AbstractQueuedSynchronizer {
        //是否锁已经被持有
        public boolean isHeldExclusively() {
            return getState() == 1;
        }

        //如果state为0 则尝试获取锁
        public boolean tryAcquire(int arg) {
            assert arg == 1;
            //CAS设置状态,能保证操作的原子性，当前为状态为0,操作成功状态改为1
            if (compareAndSetState(0, 1)) {
                //设置当前独占的线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //尝试释放锁，设置state为0
        public boolean tryRelease(int arg) {
            assert arg == 1;
            //如果同步器同步器状态等于0,则抛出监视器非法状态异常
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            //设置独占锁的线程为null
            setExclusiveOwnerThread(null);
            //设置同步状态为0
            setState(0);
            return true;
        }

        //返回Condition,每个Condition都包含了一个Condition队列
        Condition newCondition() {
            return new ConditionObject();
        }
    }
}
