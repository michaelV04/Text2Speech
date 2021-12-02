package com.company;

import java.util.ArrayList;

public class Container {
    ArrayList<Object> dingeInside = new ArrayList<>();

    public void addThing(Item item) {
        dingeInside.add(item);
    }
    public void removeThing(Item item) {
        dingeInside.remove(item);
    }
}
