package com.xset.my.sweetbox;

import com.xset.my.sweetbox.data.SweetBox;
import com.xset.my.sweetbox.data.sweet.*;

import java.util.ArrayList;
import java.util.List;

public class Run {

    private final static SweetBox SWEET_BOX;

    static {
        Candy zolotoyKluchik = new Candy("Zolotoy kluchik", 1200, 50, CandyType.TOFFEE);
        Chocolate milka = new Chocolate("Milka", 100, 70, ChocolateType.MILK);
        Cookie pryanya = new Cookie("Pryanya", 50, 130, CookieType.GINGERBREAD);

        SWEET_BOX = new SweetBox(new ArrayList<>(List.of(zolotoyKluchik, milka, pryanya)));
    }

    public static void main(String[] args) {
        System.out.println("Total weight: " + SWEET_BOX.getTotalWeight());
        System.out.println("Total price: " + SWEET_BOX.getTotalPrice());
        System.out.println(SWEET_BOX.getTotalInfo());
    }

    private static void test() {
        Candy maska = new Candy("Maska", 1500, 100, CandyType.CHOCOLATE);
        SWEET_BOX.addSweet(maska);
        System.out.println(SWEET_BOX.getTotalInfo());

        //SWEET_BOX.removeByIndex(3);
        //System.out.println(SWEET_BOX.getTotalInfo());

        System.out.println("Total weight: " + SWEET_BOX.getTotalWeight());
        double finalWeight = SWEET_BOX.smartRemoveByPrice();
        System.out.println(finalWeight);
    }
}
