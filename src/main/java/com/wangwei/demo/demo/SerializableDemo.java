package com.wangwei.demo.demo;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temfile"));
        oos.writeObject(Singleton.getSingleton());

        File file = new File("temfile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton newInstance = (Singleton) ois.readObject();

        System.out.println(newInstance == Singleton.getSingleton());
    }
}


