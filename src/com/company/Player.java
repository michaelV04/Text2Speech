package com.company;

public class Player extends Entities{

    public Player(String name,int hp, int ad, int armor, int crit, int lvl, int speed) {
        super(name,hp, ad, armor, crit, lvl, speed);
    }

    public void move(Room x,Map y){
        y.showMap();
        System.out.println("You are in "+x.getRoomName()+"The Exits are:");
        if(x.getNorthExitType() == 1){
            System.out.println("-  North");
        }else if(x.getWestExitType() == 1){
            System.out.println("-  West");
        }else if(x.getEastExitType() == 1){
            System.out.println("-  East");
        }else if(x.getSouthExitType() == 1){
            System.out.println("-  South");
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
}
