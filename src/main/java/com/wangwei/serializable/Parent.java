package com.wangwei.serializable;

import java.io.Serializable;

/**
 * @Auther wangwei
 * @Date 2018/4/27 上午11:11
 * shift+control+i 生成serialVersionUID
 */
public class Parent implements Serializable {

    private static final long serialVersionUID = -7459185987624461366L;

    public int parentValue = 100;
}
