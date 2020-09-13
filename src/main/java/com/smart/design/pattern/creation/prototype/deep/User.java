package com.smart.design.pattern.creation.prototype.deep;

import com.smart.design.pattern.creation.prototype.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @author liujunhua
 * @description: User
 * @date 2020/9/911:35
 */
@Data
@AllArgsConstructor
public class User implements Serializable, Cloneable {

    private Integer id;
    private String name;
    private Address address;

    /**
     * 深拷贝 方式1 使用clone方法
     */
    @Override
    public Object clone() {
        User user = null;
        try {
            user = (User) super.clone();
            Address address1 = (Address) address.clone();
            user.setAddress(address1);
        } catch (CloneNotSupportedException e) {

        }
        return user;
    }

    /**
     * 深拷贝 方式2 通过对象的序列化实现
     */
    public Object deepClone() {
        // 1.创建流对象
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;


        try {
            // 2. 序列化
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            // 3.反序列化
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            return (User) object;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
                byteArrayInputStream.close();
                objectInputStream.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;

    }
}