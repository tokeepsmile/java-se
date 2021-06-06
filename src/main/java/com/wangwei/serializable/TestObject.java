package com.wangwei.serializable;

import java.io.Serializable;

/**
 * @Auther wangwei
 * @Date 2018/4/27 上午11:14
 */
public class TestObject extends Parent implements Serializable {

    private static final long serialVersionUID = 2357281051818476131L;

    public int testValue = 300;

    public InnerObject innerObject = new InnerObject();
}
