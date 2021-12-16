package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Player extends Entities{
    ArrayList<Item> inventory = new ArrayList<>();


    public Player(String name,int hp, int ad, int armor, int crit, int lvl, int speed,Room destinationRoom,Map currentMap) {
        super(name,hp, ad, armor, crit, lvl, speed,currentMap,destinationRoom);
          }

    public void move(String destination) {
        Room destinationRoom = new Room("x","x",0,0,0,0,0,0);
        Map z = actualMap;
        for (int i = 0; i < z.roomsS0.size()-1; i++) {
            if (z.roomsS0.get(i) != null) {
                if (Objects.equals(z.roomsS0.get(i).getRoomName(), destination)) {
                    destinationRoom.setRoom(z.roomsS0.get(i).getRoomName(), z.roomsS0.get(i).getDescription(), z.roomsS0.get(i).getNorthExitType(), z.roomsS0.get(i).getSouthExitType(), z.roomsS0.get(i).getEastExitType(), z.roomsS0.get(i).getWestExitType(), z.roomsS0.get(i).getUpExitType(), z.roomsS0.get(i).getDownExitType(),z.roomsS0.get(i).getItemsInRoom(),z.roomsS0.get(i).getContainerInRoom(),z.roomsS0.get(i).getMobsInRoom());
                }
            }
            if (z.roomsS1.get(i) != null) {
                if (Objects.equals(z.roomsS1.get(i).getRoomName(), destination)) {
                    destinationRoom.setRoom(z.roomsS1.get(i).getRoomName(), z.roomsS1.get(i).getDescription(), z.roomsS1.get(i).getNorthExitType(), z.roomsS1.get(i).getSouthExitType(), z.roomsS1.get(i).getEastExitType(), z.roomsS1.get(i).getWestExitType(), z.roomsS1.get(i).getUpExitType(), z.roomsS1.get(i).getDownExitType(),z.roomsS1.get(i).getItemsInRoom(),z.roomsS1.get(i).getContainerInRoom(),z.roomsS1.get(i).getMobsInRoom());
                }
            }
            if (z.roomsS2.get(i) != null) {
                if (Objects.equals(z.roomsS2.get(i).getRoomName(), destination)) {
                    destinationRoom.setRoom(z.roomsS2.get(i).getRoomName(), z.roomsS2.get(i).getDescription(), z.roomsS2.get(i).getNorthExitType(), z.roomsS2.get(i).getSouthExitType(), z.roomsS2.get(i).getEastExitType(), z.roomsS2.get(i).getWestExitType(), z.roomsS2.get(i).getUpExitType(), z.roomsS2.get(i).getDownExitType(),z.roomsS2.get(i).getItemsInRoom(),z.roomsS2.get(i).getContainerInRoom(),z.roomsS2.get(i).getMobsInRoom());
                }
            }
        }
        Room x = actualRoom;
        Scanner s = new Scanner(System.in);
        int check = 0;
        check = z.checkIfExitTrue(x, destinationRoom);

        if (check == 1) {
            takeExit(destinationRoom);
            actualRoom.setRoom(destinationRoom.getRoomName(), destinationRoom.getDescription(), destinationRoom.getNorthExitType(), destinationRoom.getSouthExitType(), destinationRoom.getWestExitType(), destinationRoom.getEastExitType(), destinationRoom.getUpExitType(), destinationRoom.getDownExitType(),destinationRoom.getItemsInRoom(),destinationRoom.getContainerInRoom(),destinationRoom.getMobsInRoom());
            System.out.println("You are now in Room:" + destinationRoom.getRoomName());
            System.out.println("These are the Mobs in this Room");
            if (actualRoom.mobsInRoom.size() != 0) {
                for (int i = 0; i < actualRoom.mobsInRoom.size(); ) {
                    System.out.println(actualRoom.mobsInRoom.get(i).getName());
                    if (actualRoom.mobsInRoom.get(i).aggressive == 1){
                        int alive = combat(actualRoom.mobsInRoom.get(i).getName());
                        if (alive == 0){
                            break;
                        }
                    }else {
                        i++;
                    }
                }
            }else{
                System.out.println("No Mobs in this Room");
            }

            if(actualRoom.containerInRoom.size() != 0){
                for (int i = 0; i < actualRoom.containerInRoom.size(); i++) {
                    System.out.println(actualRoom.containerInRoom.get(i).getContainerName());
                }
            }else{
                System.out.println("No Container in this Room");
            }

            if(actualRoom.itemsInRoom.size() != 0){
                for (int i = 0; i < actualRoom.itemsInRoom.size(); i++) {
                    System.out.println(actualRoom.itemsInRoom.get(i).getItemName());
                }
            }else{
                System.out.println("No Items in this Room");
            }


        }else{
            System.out.println("You cant move there");
        }

    }


    public void searchRoom(Room x){
        Scanner s = new Scanner(System.in);
        String eingabe;
        int y = x.containerInRoom.size();
            if (x.itemsInRoom != null) {

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
                    if (x.containerInRoom.size() != 0) {
                        z = 0;
                        System.out.println("You have found a Container!\nWould you like to put something in the Container or grab it? Or leave it and look further?");
                        String abcdefg;
                        abcdefg = s.next();
                        if (Objects.equals(abcdefg, "put")) {
                            System.out.println("Which Item would you like to put into the Container?");
                            for (int j = 0; j < x.containerInRoom.size(); j++) {
                                System.out.println("-" + inventory.get(j).getItemName());
                            }
                            String ci;
                            ci = s.next();
                            while (z < inventory.size()) {
                                if (Objects.equals(ci, inventory.get(z).getItemName())) {
                                    putIntoContainer(x.containerInRoom.get(z), inventory.get(z));
                                }
                                z++;
                            }
                        } else if (Objects.equals(abcdefg, "grab")) {
                            while (z < x.containerInRoom.size()) {
                                pickupFromContainer(x.containerInRoom.get(z));
                                z++;
                            }
                        } else if (Objects.equals(abcdefg, "leave")) {

                        }

                    }else {
                        System.out.println("There are no Containers in this Room");
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
            } else {
                System.out.println("There are no items in this Room");
            }
//

    }



    public void takeExit(Room y){
        if (location.size() != 0) {
            location.remove(0);
        }
        actualRoom.setRoom(y.getRoomName(),y.getDescription(),y.getNorthExitType(),y.getSouthExitType(),y.getWestExitType(),y.getEastExitType(),y.getUpExitType(),y.getDownExitType(),y.getItemsInRoom(),y.getContainerInRoom(),y.getMobsInRoom());
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
                z++;
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
            System.out.println("This Item does not exist in this Container");
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


    @Override
    public void pickupItem(Item item) {
        super.pickupItem(item);
        System.out.println("You picked up " + item.getItemName());
    }

    public int combat(String mob) {
        Random random = new Random();
        Random mobRandom = new Random();
        Scanner s = new Scanner(System.in);
        String eingabe;
        Mob m = new Mob("null",0,0,0,0,0,0,getActualRoom(),getActualMap(),0);

        System.out.println("A "+ mob +" Appeared!");
        System.out.println("Fight == 1");
        System.out.println("Run away == 2");
        eingabe = s.next();
        if (Objects.equals(eingabe, "1")){
            for (int i = 0; i < actualRoom.mobsInRoom.size(); i++) {
                if (Objects.equals(mob, actualRoom.mobsInRoom.get(i).getName())) {
                    m.addAd(actualRoom.mobsInRoom.get(i).getAd());
                    m.setName(actualRoom.mobsInRoom.get(i).getName());
                    m.addHp(actualRoom.mobsInRoom.get(i).getHp());
                    m.addArmor(actualRoom.mobsInRoom.get(i).getArmor());
                    m.addCrit(actualRoom.mobsInRoom.get(i).getCrit());
                    m.addLvl(actualRoom.mobsInRoom.get(i).getLvl());
                    m.addSpeed(actualRoom.mobsInRoom.get(i).getSpeed());
                    m.actualRoom = actualRoom.mobsInRoom.get(i).actualRoom;
                    m.actualMap = actualRoom.mobsInRoom.get(i).actualMap;
                }
            } if (Objects.equals(m.getName(), "null")){
                System.out.println("This Mob does not exist or is not in this Room");
            }

            while (getHp() > 0 && m.getHp() > 0) {
                if (getSpeed() >= m.getSpeed()) {
                    System.out.println("You attack");
                    int crit = getCrit();
                    int mobDmg = m.getArmor() - getAd();
                    int rand = random.nextInt(100);
                    if (rand <= crit) {
                        mobDmg *= 2;
                        System.out.println("You have landed a critical hit");
                    }
                    if (mobDmg < 0) {
                        m.addHp(mobDmg);
                        System.out.println("The " + mob + " got " + mobDmg + " damage");
                    } else {
                        System.out.println("The " + mob + " blocked the attack");
                    }
                    if (m.getHp() > 0) {
                        System.out.println("The " + mob + " attacks");
                        int mobCrit = m.getCrit();
                        int dmg = getArmor() - m.getAd();

                        if (rand < mobCrit) {
                            dmg *= 2;
                            System.out.println("The " + mob + " landed a critical hit");
                        }
                        if (dmg < 0) {
                            addHp(dmg);
                            System.out.println("You got " + dmg + " damage");
                        } else {
                            System.out.println("You've blocked the attack");
                        }
                        System.out.println("Your stats:");
                        showStats();
                        System.out.println("\n Enemies stats");
                        m.showStats();
                    } else {
                        System.out.println("The "+mob+" died from your attack");
                        actualRoom.delMob(m);
                    }
                }else{
                    System.out.println("The " + mob + " attacks");
                    int mobCrit = m.getCrit();
                    int dmg = getArmor() - m.getAd();
                    int rand = random.nextInt(100);
                    if (rand == mobCrit) {
                        dmg *= 2;
                        System.out.println("The " + mob + " landed a critical hit");
                    }
                    if (dmg < 0) {
                        addHp(dmg);
                        System.out.println("You got " + dmg + " damage");
                    } else {
                        System.out.println("You've blocked the attack");
                    }
                    if (getHp() > 0) {
                        System.out.println("You attack");
                        int crit = getCrit();
                        int mobDmg = m.getArmor() - getAd();
                        rand = random.nextInt(crit);
                        if (rand == crit) {
                            mobDmg *= 2;
                            System.out.println("You have landed a critical hit");
                        }
                        if (mobDmg < 0) {
                            m.addHp(mobDmg);
                            System.out.println("The " + mob + " got " + mobDmg + " damage");
                        } else {
                            System.out.println("The " + mob + " blocked the attack");
                        }
                    }
                    System.out.println("Your stats:");
                    showStats();
                    System.out.println("\n Enemies stats");
                    m.showStats();
                }
            }
            if (getHp() <= 0){
                System.out.println("You died");
                return 0;
            }else{
                System.out.println("You have killed "+ m.getName());
                return 1;
            }
        }else if (Objects.equals(eingabe, "2")){
            System.out.println("You ran away");
            return 1;
            // TODO: Look if mob is alive or if he's disappeared
        }else {
            System.out.println("Invalid Input");
        }

        return 1;
    }

}
