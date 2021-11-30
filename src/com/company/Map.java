package com.company;

import java.util.ArrayList;


public class Map {
    private String name;
    ArrayList<Room> roomsS1 = new ArrayList<>();
    ArrayList<Room> roomsS0 = new ArrayList<>();
    ArrayList<Room> roomsS2 = new ArrayList<>();


    public Map(String mapname){
        this.name = mapname;
        for (int i = 0; i < 64; i++) {
            roomsS0.add(null);
            roomsS1.add(null);
            roomsS2.add(null);
        }
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
        System.out.print(roomsS2.get(1));
        System.out.println(roomsS2.get(2));
        System.out.print(roomsS2.get(3));
        System.out.println(roomsS2.get(4));

        System.out.print(roomsS1.get(1));
        System.out.println(roomsS1.get(2));
        System.out.print(roomsS1.get(3));
        System.out.println(roomsS1.get(4));

        System.out.print(roomsS0.get(1));
        System.out.println(roomsS0.get(2));
        System.out.print(roomsS0.get(3));
        System.out.println(roomsS0.get(4));
    }



}
