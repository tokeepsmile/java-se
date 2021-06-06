package com.wangwei.design.pattern.behavior.iterator;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * @Author wangwei
 * @Date 2021/4/6 1:17 下午
 * @Version 1.0
 */
public class ArrayIterator<E> implements Iterator<E>{

    private int cursor;

    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();
    }

    @Override
    public E currentItem() throws NoSuchAlgorithmException {
        if (cursor >= arrayList.size()){
            throw new NoSuchAlgorithmException();
        }
        return arrayList.get(cursor);
    }

    @Override
    public void next() {
        cursor++;
    }
}
