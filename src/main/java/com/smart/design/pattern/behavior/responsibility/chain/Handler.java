package com.smart.design.pattern.behavior.responsibility.chain;

import lombok.Setter;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/12/1515:24
 */
@Setter
public abstract class Handler {

    protected Handler successor;

    public abstract void handlerRequest(Request request);

}