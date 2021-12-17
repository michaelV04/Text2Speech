package com.company;

import java.util.Objects;

public class Mob extends Entities implements Mutations{
    int aggressive = 1;



    public Mob(String name, int hp, int ad, int armor, int crit, int lvl, int speed, Room destinationRoom, Map currentMap, int aggressive) {
        super(name, hp, ad, armor, crit, lvl, speed, currentMap, destinationRoom);
        this.aggressive = aggressive;
    }

    public boolean inventoryFull() {
        if (inventory.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Item getItem() {
        if (inventory.size() > 0) {
            for (Item i : inventory) {
                return i;
            }
        } else {
            return null;
        }
        return null;
    }
}

