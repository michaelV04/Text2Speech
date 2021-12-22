package com.company;

public class Item {
    private final String name;
    private final int hp;
    private final int ad;
    private final int armor;
    private final int crit;
    private final int speed;

    /**
     * Setzt die Parameter
     * @param itemName Name
     * @param hp Leben
     * @param ad Angriffsschaden
     * @param armor Rüstung
     * @param crit Critchanche
     * @param speed Geschwindigkeit
     */
    public Item(String itemName,int hp,int ad,int armor,int crit,int speed){
        this.name = itemName;
        this.ad = ad;
        this.armor = armor;
        this.hp = hp;
        this.crit = crit;
        this.speed = speed;
    }

    /**
     * @return Name
     */
    public String getItemName(){
        return name;
    }

    /**
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @return ad
     */
    public int getAd() {
        return ad;
    }

    /**
     * @return armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * @return crit
     */
    public int getCrit() {
        return crit;
    }

    /**
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }
}
