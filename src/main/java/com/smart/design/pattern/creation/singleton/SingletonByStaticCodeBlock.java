package com.smart.design.pattern.creation.singleton;

/**
 * @author liujunhua
 * @date 2020/11/1610:30
 *
 * @description: 饿汉式（静态代码块）
 * <p>
 * 这种方式和饿汉式（静态常量）方式其实类似，只不过将类的实例化过程放在了静态代码块中也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。
 * 优点和缺点跟饿汉式（静态常量）方式是一样的
 * <p>
 * 结论：cinit
 * 这种单例模式可用，可能造成内存浪费
 * 适合复杂实例化
 */
public class SingletonByStaticCodeBlock {

    // 1. 构造器私有化
    private SingletonByStaticCodeBlock() {
    }

    // 2. 类内部创建对象,在静态代码块中创建
    private static SingletonByStaticCodeBlock instance;

    static {
        // 读取初始化数据才能实例化对象的场景
        // 实例化前读取配置信息等
        /*Properties properties=new Properties();
        try {
            properties.load(Singleton02.class.getClassLoader().getResourceAsStream("single.properties"));
        } catch (IOException e) {
           throw new RuntimeException(e);
        }*/
        instance = new SingletonByStaticCodeBlock();
    }

    // 3. 向外暴露一个静态公共方法：getInstance()
    public static SingletonByStaticCodeBlock getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("2. 饿治式（静态代码块）测试");
        SingletonByStaticCodeBlock instance3 = SingletonByStaticCodeBlock.getInstance();
        SingletonByStaticCodeBlock instance4 = SingletonByStaticCodeBlock.getInstance();
        System.out.println(instance3 == instance4);
        System.out.println(instance3.hashCode());
        System.out.println(instance4.hashCode());
    }

}
