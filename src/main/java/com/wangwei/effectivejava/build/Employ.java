package com.wangwei.effectivejava.build;

/**
 * @auther wangwei
 * @date 2019-05-26 17:58
 */
public class Employ {
    private int age;

    private String name;

    private int salary;

    private String sex;

    public static class Builder{
        private int age;

        private String name;


        private int salary = 0;

        private String sex = "";

        public Builder(String name, int age){
            this.name = name;
            this.age = age;
        }

        public Builder salary(int val){
            salary = val;

            return this;
        }

        public Builder sex(String val){
            sex = val;

            return this;
        }

        public Employ build(){
            return new Employ(this);
        }

    }


    private Employ(Builder builder){
        age = builder.age;
        name = builder.name;
        salary = builder.salary;
        sex = builder.sex;

    }

    @Override
    public String toString() {
        return "Employ{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", sex='" + sex + '\'' +
                '}';
    }
}
