package com.smart.design.pattern.behavior.responsibility.chain;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/12/1515:24
 */
public class Client {

    public static void main(String[] args) {

        Handler handlerA=new ConcreteHandlerA();
        Handler handlerB=new ConcreteHandlerB();
        Handler handlerC=new ConcreteHandlerC();
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        Request request= new Request();

        request.setQuantity(10);
        handlerA.handlerRequest(request);

        request.setQuantity(25);
        handlerA.handlerRequest(request);
    }

}