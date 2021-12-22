package com.company;

import java.util.ArrayList;
import java.util.Objects;


public class Room {
    ArrayList<Item> itemsInRoom = new ArrayList<>();
    ArrayList<Container> containerInRoom = new ArrayList<>();
    ArrayList <Mob> mobsInRoom = new ArrayList<>();

    private int pos;
    public String description;
    private int northExitType;
    private int southExitType;
    private int westExitType;
    private int eastExitType;
    private int upExitType;
    private int downExitType;
    private String roomName;

    /**
     * setzt die Parameter
     * @param roomname Raumname
     * @param description Raum Beschreibung
     * @param nExitType Nordausgang
     * @param sExitType Südausgang
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
     * @return gibt Raum name zurück, wenn existiert
     */
    public String getRoomName(){
        return Objects.requireNonNullElse(roomName, "No room");
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
     * @return Postion des Spielers, wenn keine vorhanden wird 1000 returned
     */
    public int getPos(){
        if (pos == 0){
            return 1000;
        }
        return pos;
    }

    /**
     * fügt ein Item zum Room hinzu
     * @param item Item
     */
    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    /**
     * Entfernt ein Item aus dem Room
     * @param item Item
     */
    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }

    /**
     * Fügt einen Container zum Raum hinzu
     * @param container Container
     */
    public void addContainer(Container container) {
        containerInRoom.add(container);
    }

    /**
     * Setzt den Raum
     * @param roomname Raumname
     * @param description Raum Beschreibung
     * @param northExit Nordausgang
     * @param southExit Südausgang
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
     * Mob x wird zum Raum hinzugefügt
     */
    public void addMob(Mob x){
        mobsInRoom.add(x);
    }

    /**
     * Mob wird aus dem Raum gelöscht
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
