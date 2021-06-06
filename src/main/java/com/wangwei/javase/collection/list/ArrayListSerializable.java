package com.wangwei.javase.collection.list;


import java.io.*;
import java.util.ArrayList;

public class ArrayListSerializable {

    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.size());
        list.add("wangei");
        list.add("demo");
        list.add("test");

        System.out.println("Init list : " + list);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list"));
        oos.writeObject(list);

        oos.close();

        File file = new File("list");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ArrayList<String> newList = (ArrayList<String>) ois.readObject();

        ois.close();
        if (file.exists())
            file.delete();
        System.out.println("newlist " + newList);
    }

}
