package com.company;

import java.util.ArrayList;

public class Container {
    ArrayList<Object> dingeInside = new ArrayList<>();

    public void addThing(Item item) {
        dingeInside.add(item);
    }
    public boolean removeThing(Item item) {
        if(dingeInside.remove(item)) {
            return true;
        } else {
            return false;
        }
    }
}
