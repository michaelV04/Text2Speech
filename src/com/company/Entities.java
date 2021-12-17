package com.company;

import java.util.ArrayList;


public abstract class Entities {
    Room actualRoom = new Room("x", "x", 0, 0, 0, 0, 0, 0);
    Map actualMap = new Map("x", 4);


    private String name;
    ArrayList<Item> inventory = new ArrayList<>();

    private int hp;
    private int ad;
    private int armor;
    private int crit;
    private int lvl;
    private int speed;

    public Entities(String name, int hp, int ad, int armor, int crit, int lvl, int speed, Map currentMap, Room destinationRoom) {
        this.name = name;
        this.hp = hp;
        this.ad = ad;
        this.armor = armor;
        this.crit = crit;
        this.lvl = lvl;
        this.speed = speed;

        actualMap.setMapSize(currentMap.getMapSize());
        actualMap.setName(currentMap.getName());
        actualMap.setS1(currentMap.getS1());
        actualMap.setS0(currentMap.getS0());
        actualMap.setS2(currentMap.getS2());
//
        actualRoom.setRoom(destinationRoom.getRoomName(), destinationRoom.getDescription(), destinationRoom.getNorthExitType(), destinationRoom.getSouthExitType(), destinationRoom.getWestExitType(), destinationRoom.getEastExitType(), destinationRoom.getUpExitType(), destinationRoom.getDownExitType(), destinationRoom.getItemsInRoom(), destinationRoom.getContainerInRoom(), destinationRoom.getMobsInRoom());

    }

    public int getHp() {
        return hp;
    }

    public int getAd() {
        return ad;
    }

    public int getArmor() {
        return armor;
    }

    public int getCrit() {
        return crit;
    }

    public int getLvl() {
        return lvl;
    }

    public int getSpeed() {
        return speed;
    }

    public void addHp(int x) {
        this.hp = this.hp + x;
    }

    public void addSpeed(int x) {
        this.speed = this.speed + x;
    }

    public void addLvl(int x) {
        this.lvl = this.lvl + x;
    }

    public void addCrit(int x) {
        this.crit = this.crit + x;
    }

    public void addArmor(int x) {
        this.armor = this.armor + x;
    }

    public void addAd(int x) {
        this.ad = this.ad + x;
    }

    public Room getRoom(){
        return actualRoom;
    }

    public void setRoom(Room x) {
        actualRoom = x;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getActualMap() {
        return actualMap;
    }

    public Room getActualRoom() {
        return actualRoom;
    }

    public void showStats() {
        System.out.println("HP: " + getHp());
        System.out.println("AD: " + getAd());
        System.out.println("Armor: " + getArmor());
        System.out.println("Crit: " + getCrit());
        System.out.println("Level: " + getLvl());
        System.out.println("Speed: " + getSpeed());
    }

    public void pickupItem(Item item){
        inventory.add(item);
        addHp(item.getHp());
        addAd(item.getAd());
        addArmor(item.getArmor());
        addCrit(item.getCrit());
        addSpeed(item.getSpeed());
    }


}

