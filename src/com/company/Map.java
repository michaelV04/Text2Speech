package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    private String name;
    ArrayList<Room> roomsS1 = new ArrayList<>();
    ArrayList<Room> roomsS0 = new ArrayList<>();
    ArrayList<Room> roomsS2 = new ArrayList<>();


    public Map(String mapname){
        this.name = mapname;
    }
    public String getName(){
        return name;
    }

    public void addRoom(Room x,int position,int stage){
        if (stage == 1) {
            roomsS1.add(position, x);
        }else if(stage == 0){
            roomsS0.add(position, x);
        }else if(stage == 2){
            roomsS2.add(position, x);
        }
    }

    public void showMap(){
        System.out.print(roomsS1.get(1));
        System.out.println(roomsS1.get(2));
        System.out.print(roomsS1.get(3));
        System.out.println(roomsS1.get(4));
    }



}
