package com.smart.design.pattern.creation.singleton;

/**
 * @author liujunhua
 * @date 2020/11/1610:52
 * @description: 懒汉式（线程安全，同步代码块,双重检查）
 *
 * <p>
 * 1. 这种方式，本意是想对懒汉式（线程安全，同步方法）方式的改进，因为前面同步方法效率太低，
 * 改为同步产生实例化的代码块
 * <p>
 * 2. 但是这种同步并不能起到线程同步的作用。
 * <p>
 * 结棍：
 * 在实际开发中，不能使用这种方式
 */

public class SingletonByThreadSafe {

    public static void main(String[] args) {

    }

    private SingletonByThreadSafe() {
    }

    private static SingletonByThreadSafe instance;

    public static SingletonByThreadSafe getInstanceByThreadUnsafe() {
        if (instance == null) { // 其实线程不安全
            synchronized (SingletonByThreadSafe.class) {
                instance = new SingletonByThreadSafe();
            }
        }
        return instance;
    }

    /**
     * 懒汉式（线程安全，双重检查）
     *
     * 提供一个静态的公有方法，加入了双重检查代码，解决线程安全问题，同时解决赖加载问题
     * 同时保证了效率，推荐使用
     *
     *
     * 1. Double-Check概念是多线程开发中常用到的，如果代码中所示，我们进行了两次if(singleton==null)检查，这样就可以保证线程安全了。
     * 2. 这样，实例化代码只用执行一次，后面再访问时，判断if(singleton==null),直接return实例化对象也避免了进行方法反复同步
     * 3. 线程安全 延迟加载 效率较高
     *
     * <p>
     * 解决线程安全问题
     * 解决效率问题
     *
     * 提供一个静态的公有方法，加入了双重检查代码，解决线程安全问题，同时解决赖加载问题
     * 同时保证了效率，推荐使用
     */
     public static SingletonByThreadSafe getInstance() {
        if (instance == null) {//提高效率
            synchronized (SingletonByThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonByThreadSafe();
                }
            }
        }
        return instance;
    }
}
