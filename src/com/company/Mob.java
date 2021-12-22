package com.company;

/**
 * Erschaffen eines Monsters, mit seinen Eigenschaften.
 */
public class Mob extends Entities implements Mutations{
    int aggressive = 1;


    /**
     * Setzen der folgenden Eigenschaften:
     * @param name String
     * @param hp int
     * @param ad int
     * @param armor int
     * @param crit int
     * @param lvl int
     * @param speed int
     * @param destinationRoom Room
     * @param currentMap Map
     * @param aggressive int
     */
    public Mob(String name, int hp, int ad, int armor, int crit, int lvl, int speed, Room destinationRoom, Map currentMap, int aggressive) {
        super(name, hp, ad, armor, crit, lvl, speed, currentMap, destinationRoom);
        this.aggressive = aggressive;
    }

    /**
     * Schaut, ob das Inventar leer ist.
     * @return true or false
     */
    public boolean inventoryFull() {
        if (inventory.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gibt das Inventar des Monsters als Gegenstände zurück.
     * @return Item
     */
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

