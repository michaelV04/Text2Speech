package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    private String name;
    ArrayList<Room> rooms = new ArrayList<>();


    public Map(String mapname){
        this.name = mapname;
    }
    public String getName(){
        return name;
    }

    public void addRoom(Room x,int coordinate){
        rooms.add(coordinate,x);
    }

    public void showMap(){
        System.out.print(rooms.get(1));
        System.out.println(rooms.get(2));
        System.out.print(rooms.get(3));
        System.out.println(rooms.get(4));
    }



}
