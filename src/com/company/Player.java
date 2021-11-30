package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Player extends Entities{

    public Player(String name,int hp, int ad, int armor, int crit, int lvl, int speed) {
        super(name,hp, ad, armor, crit, lvl, speed);
    }

    public void move(Room x,Room y){
        Scanner s = new Scanner(System.in);

        System.out.println("You are in "+x.getRoomName()+" The Exits are:");
        if(x.getNorthExitType() == 1){
            System.out.println("-  North");
        }else if(x.getWestExitType() == 1){
            System.out.println("-  West");
        }else if(x.getEastExitType() == 1){
            System.out.println("-  East");
        }else if(x.getSouthExitType() == 1){
            System.out.println("-  South");
        }

        System.out.println("Which one would you like to use?");
        String exit;
        exit = s.next();

        if(Objects.equals(exit, "North")){
            takeExit(y);
        }else if(Objects.equals(exit, "South")){
            takeExit(y);
        }else if(Objects.equals(exit, "East")){
            takeExit(y);
        }else if(Objects.equals(exit, "West")){
            takeExit(y);
        }
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

}
