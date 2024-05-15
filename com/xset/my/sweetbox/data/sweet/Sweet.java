package com.xset.my.sweetbox.data.sweet;

import java.util.Objects;

public abstract class Sweet {

    protected String name;
    protected double weight;
    protected double price;

    public Sweet(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Sweet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweet sweet = (Sweet) o;
        return Double.compare(weight, sweet.weight) == 0 && Double.compare(price, sweet.price) == 0 && Objects.equals(name, sweet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price);
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
