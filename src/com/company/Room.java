package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Room {
    ArrayList<Item> itemsInRoom = new ArrayList<>();
    ArrayList<Container> containerInRoom = new ArrayList<>();
    ArrayList <Mob> mobsInRoom = new ArrayList<>();

    private int pos;
    public String description;
    private int northExitType = 0;
    private int southExitType = 0;
    private int westExitType = 0;
    private int eastExitType = 0;
    private int upExitType = 0;
    private int downExitType = 0;
    private String roomName;

    public Room(String roomname,String description, int nExitType, int sExitType, int eExitType, int wExitType,int upExitType, int downExitType){
        this.description = description;
        this.roomName = roomname;
        this.northExitType = nExitType;
        this.southExitType = sExitType;
        this.eastExitType = eExitType;
        this.westExitType = wExitType;
        this.upExitType = upExitType;
        this.downExitType = downExitType;

    }
    public String getRoomName(){
        if (roomName != null) {
            return roomName;
        }else{
            return "No room";
        }
    }
    public String getDescription() {
        return description;
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
    public int getUpExitType() {
        return upExitType;
    }
    public int getDownExitType() {
        return downExitType;
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
//
    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }

    public void addContainer(Container container) {
        containerInRoom.add(container);
    }

    public void setRoom(String roomname, String description, int northExit, int southExit, int westExit, int eastExit, int upExit, int downExit,ArrayList<Item> items,ArrayList<Container> container,ArrayList<Mob> mobs){
        this.roomName = roomname;
        this.description = description;
        this.northExitType = northExit;
        this.southExitType = southExit;
        this.westExitType = westExit;
        this.eastExitType = eastExit;
        this.upExitType = upExit;
        this.downExitType = downExit;
        this.itemsInRoom = items;
        this.containerInRoom = container;
        this.mobsInRoom = mobs;
    }
    public ArrayList<Item> getItemsInRoom(){
        return itemsInRoom;
    }
    public ArrayList<Container> getContainerInRoom(){
        return containerInRoom;
    }
    public ArrayList<Mob> getMobsInRoom(){
        return mobsInRoom;
    }
    public void addMob(Mob x){
        mobsInRoom.add(x);
    }
    public void delMob(Mob x){
        for (int i = 0; i < mobsInRoom.size(); i++) {
            if (Objects.equals(mobsInRoom.get(i).getName(), x.getName())){
                mobsInRoom.remove(i);
            }
        }

    }


}
