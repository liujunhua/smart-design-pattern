package com.smart.design.pattern.creation.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liujunhua
 * @date 2021/1/6 14:49
 * @description: SingletonByCAS
 *
 * CAS是项乐观锁技术，当多个线程尝试使用CAS同时更新同一个变量时，只有其中一个线程能更新变量的值，
 * 而其它线程都失败，失败的线程并不会被挂起，而是被告知这次竞争中失败，并可以再次尝试。
 *
 * 优点：
 * 用CAS的好处在于不需要使用传统的锁机制来保证线程安全,CAS是一种基于忙等待的算法,
 * 依赖底层硬件的实现,相对于锁它没有线程切换和阻塞的额外消耗,可以支持较大的并行度。
 *
 * 缺点：
 * CAS的一个重要缺点在于如果忙等待一直执行不成功(一直在死循环中),会对CPU造成较大的执行开销。
 * 另外，如果N个线程同时执行到singleton = new Singleton();的时候，会有大量对象创建，很可能导致内存溢出。
 */
public class SingletonByCAS {
    private static final AtomicReference<SingletonByCAS> INSTANCE = new AtomicReference<>();

    private SingletonByCAS() {
    }

    public static SingletonByCAS getInstance() {
        for (; ; ) {
            SingletonByCAS instance = INSTANCE.get();
            if (instance != null) {
                return instance;
            }

            instance = new SingletonByCAS();

            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }

}
