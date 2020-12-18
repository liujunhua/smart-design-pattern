package com.smart.design.pattern.behavior.responsibility.chain;

import lombok.Data;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/12/1515:27
 */
@Data
public class Request {
    private String requestType;
    private String requestContent;
    private Integer quantity;
}
