package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Player extends Entities{
    ArrayList<Item> inventory = new ArrayList<>();


    public Player(String name,int hp, int ad, int armor, int crit, int lvl, int speed,Room destinationRoom,Map currentMap) {
        super(name,hp, ad, armor, crit, lvl, speed,currentMap,destinationRoom);
          }

    public void move(String destination) {
        Room destinationRoom = new Room("x","x",0,0,0,0,0,0);
        Map z = actualMap;
        for (int i = 0; i < z.roomsS0.size(); i++) {
            if (z.roomsS0.get(i) != null) {
                if (Objects.equals(z.roomsS0.get(i).getRoomName(), destination)) {
                    destinationRoom.setRoom(z.roomsS0.get(i).getRoomName(), z.roomsS0.get(i).getDescription(), z.roomsS0.get(i).getNorthExitType(), z.roomsS0.get(i).getSouthExitType(), z.roomsS0.get(i).getEastExitType(), z.roomsS0.get(i).getWestExitType(), z.roomsS0.get(i).getUpExitType(), z.roomsS0.get(i).getDownExitType(),z.roomsS0.get(i).getItemsInRoom(),z.roomsS0.get(i).getContainerInRoom());
                }
            }
            if (z.roomsS1.get(i) != null) {
                if (Objects.equals(z.roomsS1.get(i).getRoomName(), destination)) {
                    destinationRoom.setRoom(z.roomsS1.get(i).getRoomName(), z.roomsS1.get(i).getDescription(), z.roomsS1.get(i).getNorthExitType(), z.roomsS1.get(i).getSouthExitType(), z.roomsS1.get(i).getEastExitType(), z.roomsS1.get(i).getWestExitType(), z.roomsS1.get(i).getUpExitType(), z.roomsS1.get(i).getDownExitType(),z.roomsS1.get(i).getItemsInRoom(),z.roomsS1.get(i).getContainerInRoom());
                }
            }
            if (z.roomsS2.get(i) != null) {
                if (Objects.equals(z.roomsS2.get(i).getRoomName(), destination)) {
                    destinationRoom.setRoom(z.roomsS2.get(i).getRoomName(), z.roomsS2.get(i).getDescription(), z.roomsS2.get(i).getNorthExitType(), z.roomsS2.get(i).getSouthExitType(), z.roomsS2.get(i).getEastExitType(), z.roomsS2.get(i).getWestExitType(), z.roomsS2.get(i).getUpExitType(), z.roomsS2.get(i).getDownExitType(),z.roomsS2.get(i).getItemsInRoom(),z.roomsS2.get(i).getContainerInRoom());
                }
            }
        }
        Room x = actualRoom;
        Scanner s = new Scanner(System.in);
        int check = 0;
        check = z.checkIfExitTrue(x, destinationRoom,z);

        if (check == 1) {
            takeExit(destinationRoom);
            actualRoom.setRoom(destinationRoom.getRoomName(), destinationRoom.getDescription(), destinationRoom.getNorthExitType(), destinationRoom.getSouthExitType(), destinationRoom.getWestExitType(), destinationRoom.getEastExitType(), destinationRoom.getUpExitType(), destinationRoom.getDownExitType(),destinationRoom.getItemsInRoom(),destinationRoom.getContainerInRoom());
            System.out.println("You are now in Room:" + destinationRoom.getRoomName());
        }else{
            System.out.println("You cant move there");
        }

    }

    public Room getRoom(){
        return actualRoom;
    }

    public void searchRoom(Room x){
        Scanner s = new Scanner(System.in);
        String eingabe;
        int y = x.containerInRoom.size();
        if (x.itemsInRoom != null){
            //list items
            System.out.println("The Items in the Room are:");
            int i = x.itemsInRoom.size();
            int z = 0;
            while (z < i) {
                System.out.println(x.itemsInRoom.get(z).getItemName());
                z++;
            }
            if (x.containerInRoom != null) {
                //list container
                System.out.println("The Container in the Room are");
                z = 0;
                while (z < y) {
                    System.out.println(x.containerInRoom.get(z).getContainerName());
                    z++;
                }
                    z = 0;
                    System.out.println("You have found a Container!\nWould you like to put something in the Container or grab it? Or leave it and look further?");
                    String abcdefg;
                    abcdefg = s.next();
                    if(Objects.equals(abcdefg, "put")){
                        System.out.println("Which Item would you like to put into the Container?");
                        for (int j = 0; j < x.containerInRoom.size(); j++) {
                            System.out.println("-"+inventory.get(j).getItemName());
                        }
                        String ci;
                        ci = s.next();
                        while (z<inventory.size()) {
                            if (Objects.equals(ci, inventory.get(z).getItemName())) {
                                putIntoContainer(x.containerInRoom.get(z), inventory.get(z));
                            }
                            z++;
                        }
                    }else if (Objects.equals(abcdefg, "grab")){
                        while (z < x.containerInRoom.size()) {
                            pickupFromContainer(x.containerInRoom.get(z));
                            z++;
                        }
                    }else if (Objects.equals(abcdefg, "leave")){

                    }

            }


            z = 0;
            if (x.itemsInRoom.size() != 0) {
                System.out.println("What Item would you like to pick up");
                eingabe = s.next();

                while (z < i) {
                    if (Objects.equals(eingabe, x.itemsInRoom.get(z).getItemName())) {
                        pickupItem(x.itemsInRoom.get(z));
                    }
                    z++;
                }
            }
        }else{
            System.out.println("There are no items in this room");
        }


    }

    public void showStats(){
        System.out.println("HP: "+ getHp());
        System.out.println("AD: "+getAd());
        System.out.println("Armor: "+getArmor());
        System.out.println("Crit: "+getCrit());
        System.out.println("Level: "+getLvl());
        System.out.println("Speed: "+getSpeed());
    }

    public void takeExit(Room y){
        if (location.size() != 0) {
            location.remove(0);
        }
        actualRoom.setRoom(y.getRoomName(),y.getDescription(),y.getNorthExitType(),y.getSouthExitType(),y.getWestExitType(),y.getEastExitType(),y.getUpExitType(),y.getDownExitType(),y.getItemsInRoom(),y.getContainerInRoom());
        location.add(y);

    }

    public void pickupFromContainer(Container container) {
        Scanner s = new Scanner(System.in);
        int z = 0;
        System.out.println("These are the Items in the " + container.getContainerName());
        for (int i = 0; i < container.dingeInside.size(); i++) {
            System.out.println(container.dingeInside.get(i).getItemName());
        }

        System.out.println("What would you like to pick up? \n -all\n-itemName");
        String eingabe;
        eingabe = s.next();

        if(Objects.equals(eingabe, "all")){
            for (int i = 0; i < container.dingeInside.size(); i++) {
                pickupItem(container.dingeInside.get(i));
            }
        } else {
            for (int i = 0; i < container.dingeInside.size(); i++) {
                if (Objects.equals(container.dingeInside.get(i).getItemName(), eingabe)){
                    pickupItem(container.dingeInside.get(i));
                    System.out.println("Item: " + container.dingeInside.get(i).getItemName() + " has been picked up");
                    z++;
                }
            }
        }
        if (z == 0){
            System.out.println("This Item doesnt exist in this Container");
        }
    }

    public void putIntoContainer(Container container, Item item) {
        if (inventory.remove(item)) {
            inventory.remove(item);
            container.addThing(item);
            System.out.println("You put the item " + item.getItemName() + " into " + container.getContainerName());
        } else {
            System.out.println("This is not a valid item, to put it into " + container.getContainerName());
        }
    }
    
    public void showOptions(){
        System.out.println("You can go:");
        if (actualRoom.getDownExitType() == 1){
            System.out.println("-Up");
        }if (actualRoom.getEastExitType() == 1){
            System.out.println("-East");
        }if (actualRoom.getWestExitType() == 1){
            System.out.println("-West");
        }if (actualRoom.getNorthExitType() == 1){
            System.out.println("-North");
        }if (actualRoom.getSouthExitType() == 1){
            System.out.println("-South");
        }if (actualRoom.getDownExitType() == 1){
            System.out.println("-Down");
        }
    }

    public void showInventory() {
        System.out.println("You have following items in your inventory:");
        if (inventory.size() != 0) {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(inventory.get(i).getItemName());
            }
        }else{
            System.out.println("You have no Items in your Inventory");
        }
    }

    public void pickupItem(Item item){
        inventory.add(item);
        System.out.println("You picked up " + item.getItemName());
    }

    public Room getActualRoom(){
        return actualRoom;
    }

    public void fight(){

    }
}
