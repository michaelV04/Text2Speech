package com.company;

import java.util.ArrayList;

public class Room {
    // ArrayList<Exit> exits = new ArrayList<>();
    ArrayList<Item> itemsInRoom = new ArrayList<>();
    private int pos;
    public String description;
    private int northExitType = 0;
    private int southExitType = 0;
    private int westExitType = 0;
    private int eastExitType = 0;
    private String roomName;

    public Room(String roomname,String description, int nExitType, int sExitType, int eExitType, int wExitType){
        this.description = description;
        this.roomName = roomname;
        this.northExitType = nExitType;
        this.southExitType = sExitType;
        this.eastExitType = eExitType;
        this.westExitType = wExitType;

    }
    public String getRoomName(){
        return roomName;
    }
    public int getNorthExitType(){
        return northExitType;
    }

    public int getSouthExitType(){
        return southExitType;
    }
    public int getWestExitType(){
        return westExitType;
    }
    public int getEastExitType() {
        return eastExitType;
    }

    public void setPos(int pos){
        this.pos = pos;
    }
    public int getPos(){
        if (pos == 0){
            return 1000;
        }
        return pos;
    }

    /*
    public void addExit(Exit exitType) {
        exits.add(exitType);
    }

    public void removeExit(Exit exitType) {
        exits.remove(exitType);
    }
*/
    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }
/*
    public void addRoom(String roomName) {
        this.roomName = roomName;
    }

    public void addWall(String wallType) {
        this.wallType = wallType;
    }

 */
}
