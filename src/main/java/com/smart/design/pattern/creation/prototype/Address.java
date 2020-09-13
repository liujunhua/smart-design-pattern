package com.smart.design.pattern.creation.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/915:05
 */
@Data
@AllArgsConstructor
public class Address implements Serializable, Cloneable {
    private String province;
    private String city;
    private String area;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
