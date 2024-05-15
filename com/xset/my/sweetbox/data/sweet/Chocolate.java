package com.xset.my.sweetbox.data.sweet;

import java.util.Objects;

public class Chocolate extends Sweet {

    private ChocolateType type;

    public Chocolate(String name, double weight, double price, ChocolateType type) {
        super(name, weight, price);
        this.type = type;
    }

    public ChocolateType getType() {
        return type;
    }

    public void setType(ChocolateType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chocolate chocolate = (Chocolate) o;
        return type == chocolate.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
