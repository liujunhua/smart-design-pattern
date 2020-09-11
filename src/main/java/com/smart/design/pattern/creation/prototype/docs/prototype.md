原型设计模式

创建型设计模式

面试：

使得UML类图画出原型模式核心角色

原型设计模式的深拷贝和浅拷贝是什么，并写出深拷贝的两种方式的源码

1. 重写clone方法实现深拷贝

2. 使用序列化来实现深拷贝

在Spring框架中哪里使用到原型模式，并对源码进行分析

bean.xml

```xml
<bean id="id" class="com.smart.bean.demo" scope="prototype"></bean>
```