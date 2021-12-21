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

    /**
     * setzt die Paramter
     * @param roomname Raumname
     * @param description Raum beschreibung
     * @param nExitType Nordausgang
     * @param sExitType Suedausgang
     * @param eExitType Ostausgang
     * @param wExitType Westausgang
     * @param upExitType Ausgang nach oben
     * @param downExitType Ausgang nach unten
     */
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

    /**
     * @return gibt Raum name zurueck wenn existiert
     */
    public String getRoomName(){
        if (roomName != null) {
            return roomName;
        }else{
            return "No room";
        }
    }

    /**
     * @return Beschreibung
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return northExitType
     */
    public int getNorthExitType(){
        return northExitType;
    }

    /**
     * @return southExitType
     */
    public int getSouthExitType(){
        return southExitType;
    }

    /**
     * @return westExitType
     */
    public int getWestExitType(){
        return westExitType;
    }

    /**
     * @return eastExitType
     */
    public int getEastExitType() {
        return eastExitType;
    }

    /**
     * @return upExitType
     */
    public int getUpExitType() {
        return upExitType;
    }

    /**
     * @return downExitType
     */
    public int getDownExitType() {
        return downExitType;
    }

    /**
     * Setzt die position des Spielers auf der Map
     * @param pos position auf der Map
     */
    public void setPos(int pos){
        this.pos = pos;
    }

    /**
     * @return Postion des Spielers wenn keine vorhanden wird 1000 returned
     */
    public int getPos(){
        if (pos == 0){
            return 1000;
        }
        return pos;
    }

    /**
     * fuegt ein Item zum Room hinzu
     * @param item Item
     */
    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    /**
     * Entefernt ein Item aus dem Room
     * @param item Item
     */
    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }

    /**
     * Fuegt einen Container zum Raum hinzu
     * @param container Container
     */
    public void addContainer(Container container) {
        containerInRoom.add(container);
    }

    /**
     * Setzt den Raum
     * @param roomname Raumname
     * @param description Raum beschreibung
     * @param northExit Nordausgang
     * @param southExit Suedausgang
     * @param eastExit Ostausgang
     * @param westExit Westausgang
     * @param upExit Ausgang nach oben
     * @param downExit Ausgang nach unten
     * @param items items im Raum
     * @param container Container im Raum
     * @param mobs Mobs im Raum
     */
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

    /**
     * @return Items im Raum
     */
    public ArrayList<Item> getItemsInRoom(){
        return itemsInRoom;
    }

    /**
     * @return Container im Raum
     */
    public ArrayList<Container> getContainerInRoom(){
        return containerInRoom;
    }

    /**
     * @return Mobs im Raum
     */
    public ArrayList<Mob> getMobsInRoom(){
        return mobsInRoom;
    }

    /**
     * @param x Mob
     * Mob x wird zum Raum hinzugefuegt
     */
    public void addMob(Mob x){
        mobsInRoom.add(x);
    }

    /**
     * Monb wird aus dem Raum geloescht
     * @param x Mob
     */
    public void delMob(Mob x){
        if(mobsInRoom.get(0).inventoryFull()) {
            for (int i = 0; i < mobsInRoom.size(); i++) {
                if (Objects.equals(mobsInRoom.get(i).getName(), x.getName())){
                    Item item = mobsInRoom.get(i).getItem();
                    itemsInRoom.add(item);
                    System.out.println("The " + mobsInRoom + " has dropped " + item);
                    mobsInRoom.remove(i);
                }
            }
        } else {
            for (int i = 0; i < mobsInRoom.size(); i++) {
                if (Objects.equals(mobsInRoom.get(i).getName(), x.getName())){
                    mobsInRoom.remove(i);
                }
            }
        }

    }


}
