package com.company;

import java.util.ArrayList;

public abstract class Entities {
    private String name;
    ArrayList<Room> location = new ArrayList<>();
    private int hp;
    private int ad;
    private int armor;
    private int crit;
    private int lvl;
    private int speed;
    private boolean mutationX = false;

    public Entities(String name, int hp,int ad, int armor, int crit, int lvl, int speed){
        this.name = name;
        this.hp = hp;
        this.ad = ad;
        this.armor = armor;
        this.crit = crit;
        this.lvl = lvl;
        this.speed = speed;
    }
    public int getHp(){
        return hp;
    }
    public int getAd(){
        return ad;
    }
    public int getArmor(){
        return armor;
    }
    public int getCrit(){
        return crit;
    }
    public int getLvl(){
        return lvl;
    }
    public int getSpeed(){
        return speed;
    }

    public void addHp(int x){
        this.hp = this.hp + x;
    }

    public void addSpeed(int x){
        this.speed = this.speed + x;
    }
    public void addLvl(int x){
        this.lvl = this.lvl + x;
    }
    public void addCrit(int x){
        this.crit = this.crit + x;
    }
    public void addArmor(int x) { this.armor = this.armor + x; }
    public void addAd(int x){
        this.ad = this.ad + x;
    }

    public void addMutationX(){
        mutationX = true;
    }


    public void useMutationX(){

    }

    public void combat(Player a, Mob b){
        while(a.getHp() > 0 && b.getHp() > 0){
            if (a.getSpeed() > b.getSpeed()){

            }else{

            }
        }
    }

    public void setRoom(Room x){
        location.add(x);
    }

    public void getLocation(){
        Room x = location.get(0);
        System.out.println("You are in Room "+x.getRoomName());
    }
}
