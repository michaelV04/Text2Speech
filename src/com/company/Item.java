package com.company;

public class Item {
    private String name;

    private int hp;
    private int ad;
    private int armor;
    private int crit;
    private int speed;
    private boolean mutationX = false;

    public Item(String itemName,int hp,int ad,int armor,int crit,int speed){
        this.name = itemName;
        this.ad = ad;
        this.armor = armor;
        this.hp = hp;
        this.crit = crit;
        this.speed = speed;
    }

    public String getItemName(){
        return name;
    }
}
