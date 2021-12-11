package com.company;

public class Mob extends Entities {
    Room actualRoom = new Room("x","x",0,0,0,0,0,0);
    Map actualMap = new Map("x",4);
//TODO mobs can carry items that give them buffs and that they can drop

    public Mob(String name,int hp, int ad, int armor, int crit, int lvl, int speed,Room destinationRoom,Map currentMap) {
        super(name,hp, ad, armor, crit, lvl, speed,currentMap,destinationRoom);
          }





}
