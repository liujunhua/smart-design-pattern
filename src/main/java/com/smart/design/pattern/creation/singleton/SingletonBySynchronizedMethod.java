package com.smart.design.pattern.creation.singleton;

/**
 * @author liujunhua
 * @description: 懒汉式（线程安全，同步方法）
 * @date 2020/11/1610:47
 */
public class SingletonBySynchronizedMethod {

    private SingletonBySynchronizedMethod() {
    }

    private static SingletonBySynchronizedMethod instance;

    /**
     * 提供一个静态公有方法，加入了同步代码，解决线程不安全问题，当使用到该方法时，才去创建instance,即懒汉式
     * <p>
     * 1. 解决了线程不安全问题
     * 2. 效率太低了，每个线程在想获得类的实例时候，执行getInstance方法都要进行同步。
     * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该实例，直接return就行了，方法进行同步效率太低了
     * <p>
     * 结论：
     * 在实际开发中，不推荐使用这种方式
     *
     * @return
     */
    public static synchronized SingletonBySynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonBySynchronizedMethod();
        }
        return instance;
    }

}
