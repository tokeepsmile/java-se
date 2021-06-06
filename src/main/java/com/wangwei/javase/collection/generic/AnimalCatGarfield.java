package com.wangwei.javase.collection.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/4/4 12:02 上午
 * @Version 1.0
 */
public class AnimalCatGarfield {
    public static void main(String[] args) {
        List<Animal> animal = new ArrayList<>();
        List<Cat> cat = new ArrayList<>();
        List<Garfield> garfield = new ArrayList<>();

        animal.add(new Animal());
        cat.add(new Cat());
        garfield.add(new Garfield());

        //List<? extends Cat> extendsCarFromAnimal = animal;
        List<? super Cat> superCatFromAnimal = animal;

        List<? extends Cat> extendsCatFromCat = cat;
        List<? super Cat> superCatFroCat = cat;

        List<? extends Cat> extendsCatFromGgarfield = garfield;
        //List<? super Cat> superCatFromGgarfield = garfield;

        //extendsCatFromCat.add(new Animal());
        //extendsCatFromCat.add(new Cat());
        //extendsCatFromCat.add(new Garfield());
        //
        //superCatFroCat.add(new Animal());
        superCatFroCat.add(new Cat());
        superCatFroCat.add(new Garfield());

        Cat cat1 = extendsCatFromCat.get(0);

        Animal cat2 = extendsCatFromGgarfield.get(0);
    }
}
