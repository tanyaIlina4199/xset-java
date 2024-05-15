package com.xset.my.sweetbox.data.sweet;

import java.util.Objects;

public class Candy extends Sweet {

    private CandyType type;

    public Candy(String name, double weight, double price, CandyType type) {
        super(name, weight, price);
        this.type = type;
    }

    public Candy() {}


    public CandyType getType() {
        return type;
    }

    public void setType(CandyType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candy candy = (Candy) o;
        return type == candy.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
