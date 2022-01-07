package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

/**
 * Erschaffen eines steuerbaren Spielers, mit seinen Eigenschaften.
 */
public class Player extends Entities implements Mutations{
    /**
     *
     * @param name name des Spielers
     * @param hp leben des Spielers
     * @param ad Angriffsschaden des Spielers
     * @param armor Rüstung des Spielers
     * @param crit Critchanche des Spielers
     * @param lvl level des Spielers
     * @param speed Geschwindigkeit des Spielers
     * @param destinationRoom spawn Raum
     * @param currentMap spawn map
     * Die Parameter werden gesetzt
     */
    public Player(String name,int hp, int ad, int armor, int crit, int lvl, int speed,Room destinationRoom,Map currentMap) {
        super(name,hp, ad, armor, crit, lvl, speed,currentMap,destinationRoom);
    }

    /**
     * bewegt Spieler von Raum nach anderen und schaut, ob es möglich ist dann werden noch die container im Raum ausgeben und items. Wen aggressive mobs im Raum sind dann werden diese bekämpft.
     * @param destination Raumname wo man hin will
     * @param alive ob Spieler am Leben ist
     * @return ob Spieler am Leben ist
     */
    public int move(String destination,int alive) {
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
        int check;
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
                        alive = combat(actualRoom.mobsInRoom.get(i).getName());
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
        return alive;

    }

    /**
     * Schaut durch den Room und listet alle Items und Container im Room auf, danach wird der user gefragt, ob er was einsammeln möchte, wenn; ja werden sie eingesammelt.
     * @param x Room
     */
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


    /**
     * geht in den Übergebenen Room
     * @param y Raum
     */
    public void takeExit(Room y){
        actualRoom.setRoom(y.getRoomName(),y.getDescription(),y.getNorthExitType(),y.getSouthExitType(),y.getWestExitType(),y.getEastExitType(),y.getUpExitType(),y.getDownExitType(),y.getItemsInRoom(),y.getContainerInRoom(),y.getMobsInRoom());
    }

    /**
     * ein Item wird aus dem Container aufgesammelt
     * @param container Container
     */
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

    /**
     * Ein Item wird in den Container an der erst möglichen Stelle gegeben.
     * @param container container
     * @param item item
     */
    public void putIntoContainer(Container container, Item item) {
        if (inventory.remove(item)) {
            addHp(-item.getHp());
            addAd(-item.getAd());
            addArmor(-item.getArmor());
            addCrit(-item.getCrit());
            addSpeed(-item.getSpeed());
            inventory.remove(item);
            container.addThing(item);
            System.out.println("You put the item " + item.getItemName() + " into " + container.getContainerName());
        } else {
            System.out.println("This is not a valid item, to put it into " + container.getContainerName());
        }
    }

    /**
     * Zeigt das Inventar des Spielers und kontrolliert, falls keine vorhanden sind
     */
    public void showInventory() {
        System.out.println("You have following items in your inventory:");
        if (inventory.size() != 0) {
            for (Item item : inventory) {
                System.out.println(item.getItemName());
            }
        }else{
            System.out.println("You have no Items in your Inventory");
        }
    }

    /**
     * Ein item wird aus dem derzeitigen Raum aufgehoben.
     * @param item Item
     */
    @Override
    public void pickupItem(Item item) {
        super.pickupItem(item);
        System.out.println("You picked up " + item.getItemName());
    }

    /**
     * Der Spieler kämpft gegen den gegeben mob bis entweder mob oder Spieler stirbt. User kann eingeben, ob er kämpfen oder fliehen will.
     * @param mob Mob
     * @return ob der Spieler noch am Leben ist
     */
    public int combat(String mob) {
        Random random = new Random();
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
                        //int rand2 = random.nextInt(crit);
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

    public void showmap() {
        String location = getActualRoom().getRoomName();
        javax.swing.JFrame frame = new javax.swing.JFrame("Map");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());


        switch (location) {
            case "x" -> panel.add(new JLabel(new ImageIcon("Figures/1.jpg")));
            case "woods1" -> panel.add(new JLabel(new ImageIcon("Figures/2.jpg")));
            case "woods2" -> panel.add(new JLabel(new ImageIcon("Figures/3.jpg")));
            case "woods3" -> panel.add(new JLabel(new ImageIcon("Figures/4.jpg")));
            case "woods4" -> panel.add(new JLabel(new ImageIcon("Figures/5.jpg")));
            case "cliff1" -> panel.add(new JLabel(new ImageIcon("Figures/6.jpg")));
            case "sea1" -> panel.add(new JLabel(new ImageIcon("Figures/7.jpg")));
            case "Village_Entrance1" -> panel.add(new JLabel(new ImageIcon("Figures/8.jpg")));
            case "Village_Road1" -> panel.add(new JLabel(new ImageIcon("Figures/9.jpg")));
            case "Village_Road2" -> panel.add(new JLabel(new ImageIcon("Figures/10.jpg")));
            case "Village_Road3" -> panel.add(new JLabel(new ImageIcon("Figures/11.jpg")));
            case "Village_Road4" -> panel.add(new JLabel(new ImageIcon("Figures/12.jpg")));
            case "Village_Road5" -> panel.add(new JLabel(new ImageIcon("Figures/13.jpg")));
            case "Village_Road6" -> panel.add(new JLabel(new ImageIcon("Figures/14.jpg")));
            case "house1" -> panel.add(new JLabel(new ImageIcon("Figures/15.jpg")));
            case "house1_underground" -> panel.add(new JLabel(new ImageIcon("Figures/15.jpg")));
            case "Village_Road7" -> panel.add(new JLabel(new ImageIcon("Figures/16.jpg")));
            case "house2" -> panel.add(new JLabel(new ImageIcon("Figures/17.jpg")));
            case "house2_2ndFloor" -> panel.add(new JLabel(new ImageIcon("Figures/17.jpg")));
            case "Village_Road8" -> panel.add(new JLabel(new ImageIcon("Figures/18.jpg")));
            case "Village_Road9" -> panel.add(new JLabel(new ImageIcon("Figures/19.jpg")));
            case "Village_Road10" -> panel.add(new JLabel(new ImageIcon("Figures/20.jpg")));
            case "Village_Road11" -> panel.add(new JLabel(new ImageIcon("Figures/21.jpg")));
            case "house3" -> panel.add(new JLabel(new ImageIcon("Figures/22.jpg")));
            case "house3_2ndFloor" -> panel.add(new JLabel(new ImageIcon("Figures/22.jpg")));
            case "Village_Road12" -> panel.add(new JLabel(new ImageIcon("Figures/23.jpg")));
            case "Village_Road13" -> panel.add(new JLabel(new ImageIcon("Figures/24.jpg")));
            case "house4" -> panel.add(new JLabel(new ImageIcon("Figures/25.jpg")));
            case "Village_Road14" -> panel.add(new JLabel(new ImageIcon("Figures/26.jpg")));
            case "house5" -> panel.add(new JLabel(new ImageIcon("Figures/27.jpg")));
            case "Village_Road15" -> panel.add(new JLabel(new ImageIcon("Figures/28.jpg")));
            case "Village_Road16" -> panel.add(new JLabel(new ImageIcon("Figures/29.jpg")));
            case "church1" -> panel.add(new JLabel(new ImageIcon("Figures/30.jpg")));
            case "church1_top1" -> panel.add(new JLabel(new ImageIcon("Figures/30.jpg")));
            case "Village_Road17" -> panel.add(new JLabel(new ImageIcon("Figures/31.jpg")));
            case "Village_Road18" -> panel.add(new JLabel(new ImageIcon("Figures/32.jpg")));
            case "Village_Road19" -> panel.add(new JLabel(new ImageIcon("Figures/33.jpg")));
            case "Village_Road20" -> panel.add(new JLabel(new ImageIcon("Figures/34.jpg")));
            case "Village_Road21" -> panel.add(new JLabel(new ImageIcon("Figures/35.jpg")));
            case "Village_Road22" -> panel.add(new JLabel(new ImageIcon("Figures/36.jpg")));
            case "Village_Road23" -> panel.add(new JLabel(new ImageIcon("Figures/37.jpg")));
            case "Village_Road24" -> panel.add(new JLabel(new ImageIcon("Figures/38.jpg")));
            case "plateau_low" -> panel.add(new JLabel(new ImageIcon("Figures/39.jpg")));
            case "plateau_high" -> panel.add(new JLabel(new ImageIcon("Figures/39.jpg")));
            case "Village_Road25" -> panel.add(new JLabel(new ImageIcon("Figures/40.jpg")));
            case "Village_Road26" -> panel.add(new JLabel(new ImageIcon("Figures/41.jpg")));
            case "Village_Road27" -> panel.add(new JLabel(new ImageIcon("Figures/42.jpg")));
            case "house6" -> panel.add(new JLabel(new ImageIcon("Figures/43.jpg")));
            case "house6_underground" -> panel.add(new JLabel(new ImageIcon("Figures/43.jpg")));
            default -> {
            }
        }
        frame.add(panel);
        frame.setSize(600, 570);
        frame.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

