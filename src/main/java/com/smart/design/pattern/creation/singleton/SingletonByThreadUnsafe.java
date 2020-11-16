package com.smart.design.pattern.creation.singleton;

/**
 * @author liujunhua
 * @description: 懒汉式（线程不安全）
 * @date 2020/11/1610:44
 */
public class SingletonByThreadUnsafe {

    private SingletonByThreadUnsafe() {
    }

    private static SingletonByThreadUnsafe instance;

    /**
     * 懒汉式：延迟创建这个实例对象
     * 提供一个静态公有方法，当使用到该方法时，才去创建instance,即懒汉式
     * 在调用getInstance才创建单例对象，饿汉式
     * <p>
     * 优缺点说明
     * 起到了Lazy loading的效果，但是只能在单线程下使用
     * 如果在多线程下，一个线程进入了if(instance==null)断送语句块，还未来得及往下运行，另一个线程也通过了这个判断语句，这时便会产生多个实例
     * 所以在多线程环境下不可使用这种方式
     * <p>
     * 结论：
     * 在实际开发中，不要使用这种方式
     *
     * @return
     */
    public static SingletonByThreadUnsafe getInstance() {
        if (instance == null) {
            instance = new SingletonByThreadUnsafe();
        }
        return instance;
    }

}
