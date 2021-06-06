package com.wangwei.design.pattern.behavior.responsibility;

/**
 * @Author wangwei
 * @Date 2020/4/27 9:06 下午
 * @Version 1.0
 * 在职责链模式中，多个处理器（也就是刚刚定义中说的“接收对象”）依次处理同一个请求。一个请求先经过 A 处理器处理，
 * 然后再把请求传递给 B 处理器，B 处理器处理完后再传递给 C 处理器，以此类推，形成一个链条。
 * 链条上的每个处理器各自承担各自的处理职责，所以叫作职责链模式。
 */

public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle(){
        doHandle();
        if (successor != null){
            successor.handle();
        }
    }

    protected abstract void doHandle();
}
