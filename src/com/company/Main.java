package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        //combatTest(s);
        mainLobby(s);


    }

    public static void mainLobby(Scanner s) throws InterruptedException {
        tutorial(s);
        int x = 0;
        while (x == 0) {
            int eingabe;
            System.out.println("\t\t\t Bug Break");
            System.out.println("Tutorial = 1\nMain Story 2\nCommands and Shortcuts = 3\nClose the Game = 4");
            eingabe = s.nextInt();
            if (eingabe == 1) {
                tutorial(s);
            } else if (eingabe == 2) {
                bugBreak(s);
            } else if (eingabe == 3) {
                commands();
            }else if(eingabe == 4){
                x++;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void combatTest(Scanner s) {
        int alive = 1;
        Map testM1 = new Map("testM1",9);
        Room testR1 = new Room("testR1","x",0,0,0,0,0,0);
        Mob zombie = new Mob("zombie1",500,3000,0,0,1,50,testR1,testM1);
        testM1.addRoom(testR1,0,0);
        testR1.addMob(zombie);
        Player p1 = new Player("Hans",100,100,100,100,100,100,testR1,testM1);
        while (alive == 1) {
            alive = p1.combat("zombie1");
        }
    }

    public static void commands() {
    }

    public static void bugBreak(Scanner s) {
        startVillage(s);


    }

    public static void startVillage(Scanner s) {
        Map woodsStartVillage = new Map("Start_Village",256);
        Room woods1 = new Room("woods1","A dark place with trees nothing else to see",0,0,1,0,0,0);
        Room woods2 = new Room("woods2","A dark place with trees nothing else to see",0,0,1,0,0,0);
        Room woods3 = new Room("woods3","A dark place with trees but something is glowing nearby",0,0,1,0,0,0);
        Container chest1 = new Container("Chest1");
        woods3.addContainer(chest1);
    }


    public static void createCharacter(Player p1, Scanner s){
        int x = -1;
        while(x < 1 || x > 3) {
            System.out.println("Choose your Character:\n Tank = 1\n Warrior = 2\n Assassin = 3\n: ");
            x = s.nextInt();
            System.out.println(x);

            if (x == 1) {
                p1.addAd(-2);
                p1.addHp(20);
                p1.addArmor(5);
                p1.addSpeed(-20);
                System.out.println("You choose Tank!");
            } else if (x == 2) {
                System.out.println("You choose Warrior!");
            } else if (x == 3) {
                System.out.println("You choose Assassin!");
                p1.addAd(5);
                p1.addHp(-20);
                p1.addArmor(-2);
                p1.addSpeed(20);
            } else {
                System.out.println("Wrong Number Given\n");
            }
        }

        System.out.println("Hello Goat you are ready for your adventure.\n These are your Stats:");
        p1.showStats();
    }

    public static void playerInterface(Player p1,Scanner s,Room x){
        Map y = p1.actualMap;
        System.out.println("Welcome to the Player Interface.");
        System.out.println("You can move your Character by typing *move* then you will get a List of options");
        System.out.println("You can also look around the area your standing in with *look*");
        int xy = 0;
        while (xy == 0) {
            String command;
            System.out.println("You can move your Character by typing *move* then you will get a List of options");
            System.out.println("You can also look around the area your standing in with *look*\n Or fight a Mob with combat");
            System.out.println("You can Exit the game with exit and with inv you can open your Inventory\nWith finish you can check if you have finished the tutorial");
            command = s.next();

            if (Objects.equals(command, "look")) {
                p1.searchRoom(p1.actualRoom);
            } else if (Objects.equals(command, "move")) {
                p1.actualMap.showMap();
                System.out.println("In which Room would you like to move?");
                System.out.println("You are in Room " + p1.actualRoom.getRoomName());
                String e;
                e = s.next();
                p1.move(e);
            }else if(Objects.equals(command, "combat")){
                if (p1.actualRoom.mobsInRoom.size() == 0){
                    System.out.println("No mobs in this Room");
                }else {
                    System.out.println("Which Mob would you like to fight");
                    for (int i = 0; i < p1.actualRoom.mobsInRoom.size(); i++) {
                        System.out.println("-" + p1.actualRoom.mobsInRoom.get(i).getName()+"\n");
                        p1.actualRoom.mobsInRoom.get(i).showStats();
                    }
                    String e;
                    e = s.next();
                    for (int i = 0; i < p1.actualRoom.mobsInRoom.size(); i++) {
                        if (Objects.equals(e, p1.actualRoom.mobsInRoom.get(i).getName())) {
                            p1.combat(e);
                        }
                    }
                }

            }else if(Objects.equals(command, "exit")){
                xy++;
            }else if (Objects.equals(command, "inv")){
                p1.showInventory();
            }
            else if (Objects.equals(p1.actualRoom.getRoomName(), "roof") && Objects.equals(p1.actualMap.roomsS1.get(0).containerInRoom.get(0).dingeInside.get(0).getItemName(), "sword")){
                xy++;
            }
        }

    }

    public static void tutorial(Scanner s) throws InterruptedException {
        Map tutorial = new Map("tutorial",4);
        Room river = new Room("river","x",0,0,0,1,0,0);
        Room field = new Room("field","x",1,0,1,0,0,0);
        Room house = new Room("house","x",0,1,0,0,1,0);
        Room roof = new Room("roof","x",0,0,0,0,0,1);
        Container stone = new Container("stone");
        Container cabinet = new Container("cabinet");
        Item sword = new Item("sword",0,10,0,0,2);
        Player p1 = new Player("Goat", 100, 10, 10, 0, 1, 100, river,tutorial);

        stone.addThing(sword);
        field.addContainer(stone);
        house.addContainer(cabinet);



        tutorial.addRoom(house,0,1);
        tutorial.addRoom(roof,0,2);
        tutorial.addRoom(field,2,1);
        tutorial.addRoom(river,3,1);

        Mob m1 = new Mob("zombie", 1, 1,1, 1,1,1,house,tutorial);
        m1.setRoom(house);
        house.mobsInRoom.add(m1);

        tutorial.showMap();

        System.out.println("Wake up!");
        System.out.println("*You are standing between a river*");
        System.out.println("Your Goal is to find the SWORD then to put it into the CABINET and then to go to the ROOF");

        p1.setRoom(river);
        createCharacter(p1,s);


        TimeUnit.SECONDS.sleep(1);
        playerInterface(p1,s,p1.getActualRoom());

        System.out.println("You have finished the tutorial");


    }
}


