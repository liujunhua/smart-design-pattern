package com.smart.design.pattern.creation.singleton;

/**
 * @author liujunhua
 * @date 2020/11/169:34
 * @description: 饿汉式（静态常量）
 *
 * <p>
 * 步骤如下：
 * 1. 构造器私有化
 * 2. 类内部自行创建创建对象，并且用静态变量保存
 * 3. 向外提供这个实例，
 *
 * <p>
 * 1. 直接暴露，静态公共变量
 * 2. 用静态变量的get方法（静态公共方法）获取，getInstance()
 *
 * <p>
 * 注：强调这是一个单例，我们可以用final修饰
 *
 * <p>
 * 优点：
 * 写法简单，在类装载的时候就完成实例化，避免了线程间同步问题。
 * <p>
 * 缺点：
 * 在类装载的时候就完成实例化，没有达到Lazy Loading的效果，如果从始至终未使用这个实例，则会造成内存的浪费
 * <p>
 * 这种方式基于classloader机制避免了多线程同步问题，不过，instance在类装载时就实例化，在单例模式中大多数都是调用getInstance方法，但是导致类装载的原因有很多种，
 * 因此不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance就没有达到lazy loading的效果
 * <p>
 * 结论：
 * 这种单例械可用，可能造成内存浪费
 */
public class SingletonByStaticConst {

    // 1. 构造器私有化
    private SingletonByStaticConst() {
    }

    // 2. 类内部自行创建创建对象，并且用静态变量保存
    private final static SingletonByStaticConst instance = new SingletonByStaticConst();

    // 3. 向外暴露一个静态公共方法：getInstance()
    public static SingletonByStaticConst getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("饿汉式（静态常量）测试");
        SingletonByStaticConst instance1 = SingletonByStaticConst.getInstance();
        SingletonByStaticConst instance2 = SingletonByStaticConst.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }

}
