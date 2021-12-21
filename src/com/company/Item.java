package com.company;

public class Item {
    private String name;
    private int hp;
    private int ad;
    private int armor;
    private int crit;
    private int speed;

    /**
     * Setzt die Paramter
     * @param itemName Name
     * @param hp Leben
     * @param ad Angrifsschaden
     * @param armor Ruestung
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
