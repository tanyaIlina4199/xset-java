package com.xset.my.sweetbox.data;

import com.xset.my.sweetbox.data.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SweetBox implements ISweetBox {

    private List<Sweet> sweets = new ArrayList<>();

    public SweetBox(List<Sweet> sweets) {
        this.sweets = sweets;
    }

    public SweetBox() {}


    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    @Override
    public void removeLastSweet() {
        sweets.remove(sweets.size() - 1);
    }

    @Override
    public void removeByIndex(int index) {
        if (index < 0 || index >= sweets.size()) {
            return;
        }

        sweets.remove(index);
    }

    @Override
    public double getTotalWeight() {
        double totalWeight = 0;
        for (Sweet sweet : sweets) {
            totalWeight += sweet.getWeight();
        }

        return totalWeight;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Sweet sweet : sweets) {
            totalPrice += sweet.getPrice();
        }

        return totalPrice;
    }

    @Override
    public String getTotalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total information about sweet box: ").append("\n")
                .append("Box size: ").append(sweets.size()).append("\n");

        for (Sweet sweet : sweets) {
            sb.append("\t").append(sweet).append("\n");
        }

        return sb.toString();
    }

    @Override
    public double smartRemoveByWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the weight of the sweet box: ");
        double weight = scanner.nextDouble();

        return removeByWeight(weight);
    }

    private double removeByWeight(double weight) {
        double totalWeight = this.getTotalWeight();
        if (totalWeight < weight) {
            return totalWeight;
        }

        double minWeight = Double.MAX_VALUE;
        int indexOfMinWeight = 0;
        for (int i = 0; i < sweets.size(); i++) {
            Sweet sweet = sweets.get(i);
            double currentWeight = sweet.getWeight();
            if (currentWeight < minWeight) {
                minWeight = currentWeight;
                indexOfMinWeight = i;
            }
        }

        sweets.remove(indexOfMinWeight);

        return removeByWeight(weight);
    }

    @Override
    public double smartRemoveByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the weight of the sweet box: ");
        double weight = scanner.nextDouble();

        return removeByPrice(weight);
    }

    private double removeByPrice(double weight) {
        double totalWeight = this.getTotalWeight();
        if (totalWeight < weight) {
            return totalWeight;
        }

        double minPrice = Double.MAX_VALUE;
        int indexOfMinPrice = 0;
        for (int i = 0; i < sweets.size(); i++) {
            Sweet sweet = sweets.get(i);
            double currentPrice = sweet.getPrice();
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
                indexOfMinPrice = i;
            }
        }

        sweets.remove(indexOfMinPrice);

        return removeByPrice(weight);
    }
}
