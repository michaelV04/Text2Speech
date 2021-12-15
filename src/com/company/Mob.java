package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mob extends Entities {
    int aggressive = 1;
    ArrayList<Item> inventory = new ArrayList<>();

//TODO mobs can carry items that give them buffs and that they can drop

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

