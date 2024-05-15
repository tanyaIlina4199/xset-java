package com.xset.my.sweetbox.data;

import com.xset.my.sweetbox.data.sweet.Sweet;

public interface ISweetBox {

    void addSweet(Sweet sweet);

    void removeLastSweet();

    void removeByIndex(int index);

    double getTotalWeight();

    double getTotalPrice();

    String getTotalInfo();

    double smartRemoveByWeight();

    double smartRemoveByPrice();
}
