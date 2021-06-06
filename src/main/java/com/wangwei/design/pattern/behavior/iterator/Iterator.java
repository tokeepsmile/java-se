package com.wangwei.design.pattern.behavior.iterator;

import java.security.NoSuchAlgorithmException;

/**
 * @Author wangwei
 * @Date 2021/4/6 1:16 下午
 * @Version 1.0
 */
public interface Iterator<E> {

    boolean hasNext();

    E currentItem() throws NoSuchAlgorithmException;

    void next();

}
