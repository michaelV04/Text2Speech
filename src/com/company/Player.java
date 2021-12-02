package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entities{
    Room actualRoom = new Room("x","x",0,0,0,0,0,0);
    ArrayList<Object> inventory = new ArrayList<>();


    public Player(String name,int hp, int ad, int armor, int crit, int lvl, int speed) {
        super(name,hp, ad, armor, crit, lvl, speed);
    }

    public void move(Room x, Room destinationRoom, Map z) {
        Scanner s = new Scanner(System.in);
        int i = z.checkIfExitTrue(x, y,z);
        takeExit(y);
    }

    public Room getRoom(){
        return actualRoom;
    }

    public void searchRoom(Room x){

    }

    public void showStats(){
        System.out.println("HP: "+ getHp());
        System.out.println("AD: "+getAd());
        System.out.println("Armor: "+getArmor());
        System.out.println("Crit: "+getCrit());
        System.out.println("Level: "+getLvl());
        System.out.println("Speed: "+getSpeed());
    }

    public void takeExit(Room y){
        location.remove(0);
        location.add(y);
    }

    public void pickupContainer(Container) {

    }

}
