package com.xset.my.sweetbox.data.sweet;

import java.util.Objects;

public class Cookie extends Sweet {

    private CookieType type;

    public Cookie(String name, double weight, double price, CookieType type) {
        super(name, weight, price);
        this.type = type;
    }

    public Cookie() {}

    public CookieType getType() {
        return type;
    }

    public void setType(CookieType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cookie cookie = (Cookie) o;
        return Objects.equals(type, cookie.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
