package com.wangwei.javase.collection.set;

import java.util.Objects;

/**
 * @Author wangwei
 * @Date 2021/3/27 下午1:38
 * @Version 1.0
 */
public class EqualsObject {
    private int id;
    private String name;

    public EqualsObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 任何时候重写equals要重写hashcode
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        if (this == obj){
            return true;
        }

        EqualsObject temp = (EqualsObject) obj;
        return this.id == temp.getId() && name.equals(temp.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EqualsObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
