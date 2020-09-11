package com.smart.design.pattern.creation.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liujunhua
 * @description: User
 * @date 2020/9/911:35
 */
@Data
@AllArgsConstructor
public class User implements Cloneable {

    private Integer id;
    private String name;
    private Address address;

    /**
     * 浅拷贝
     */
    @Override
    public Object clone() {
        User user = null;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
