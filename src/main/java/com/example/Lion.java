package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    private Cubs cubs;
    private Predator predator;

    public Lion(Cubs cubs) {
        this.cubs = cubs; // объект попадает в переменную класса
    }

    public Lion(Predator predator) {
        this.predator = predator; // объект попадает в переменную класса
    }

    public int getKittens() {
        return cubs.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
