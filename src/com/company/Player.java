package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Player extends Entities{

    public Player(String name,int hp, int ad, int armor, int crit, int lvl, int speed) {
        super(name,hp, ad, armor, crit, lvl, speed);
    }

    public void move(Room x,Room y,Map z) {
        Scanner s = new Scanner(System.in);
        int i = z.checkIfExitTrue(x, y,z);
        if (i == 1) {
            System.out.println("You are in " + location.get(0).getRoomName() + " The Exits are:");
            if (location.get(0).getNorthExitType() == 1) {
                System.out.println("-  North");
            }if (location.get(0).getWestExitType() == 1) {
                System.out.println("-  West");
            }if (location.get(0).getEastExitType() == 1) {
                System.out.println("-  East");
            }if (location.get(0).getSouthExitType() == 1) {
                System.out.println("-  South");
            }if (location.get(0).getDownExitType() == 1) {
                System.out.println("-  Down");
            }if (location.get(0).getUpExitType() == 1) {
                System.out.println("-  Up");
            }

            System.out.println("Which one would you like to use?");
            String exit;
            exit = s.next();

            if (Objects.equals(exit, "North")) {
                takeExit(y);
            } else if (Objects.equals(exit, "South")) {
                takeExit(y);
            } else if (Objects.equals(exit, "East")) {
                takeExit(y);
            } else if (Objects.equals(exit, "West")) {
                takeExit(y);
            }else if (Objects.equals(exit, "Up")) {
                takeExit(y);
            }else if (Objects.equals(exit, "Down")) {
                takeExit(y);
            }
        }else{
            System.out.println("These rooms are not connected");
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
