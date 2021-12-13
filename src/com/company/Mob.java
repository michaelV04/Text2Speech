package com.company;

public class Mob extends Entities {
    int aggressive = 1;
//TODO mobs can carry items that give them buffs and that they can drop

    public Mob(String name,int hp, int ad, int armor, int crit, int lvl, int speed,Room destinationRoom,Map currentMap,int aggressive) {
        super(name,hp, ad, armor, crit, lvl, speed,currentMap,destinationRoom);
        this.aggressive = aggressive;
          }



}
