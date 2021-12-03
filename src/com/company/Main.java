package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);

        tutorial(s);

    }

    public static void createCharakter(Player p1,Scanner s){
        int x = -1;
        while(x < 1 || x > 3) {
            System.out.println("Choose your charakter:\n Tank = 1\n Warrior = 2\n Assasin = 3\n: ");
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
        System.out.println("Welcome to the Player Interface.");
        System.out.println("You can move your Character by typing *move* then you will get a List of options");
        System.out.println("You can also look around the area your standing in with *look*");

        String command;
        System.out.println("What do you want to do?");
        command = s.next();

        if (Objects.equals(command, "look")){
            p1.searchRoom(x);
        }else if(Objects.equals(command, "move")){
            System.out.println("In which Room would you like to move?");
            String e;
            e = s.next();
            p1.move(command);
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
        Item sword = new Item("sword");
        Player p1 = new Player("Goat", 100, 10, 10, 0, 1, 100, river,tutorial);

        stone.addThing(sword);

        tutorial.addRoom(house,0,1);
        tutorial.addRoom(roof,0,2);
        tutorial.addRoom(field,2,1);
        tutorial.addRoom(river,3,1);


        tutorial.showMap();

        System.out.println("Wake up!");
        System.out.println("*You are standing between a river*");

        p1.setRoom(river);
        createCharakter(p1,s);


        TimeUnit.SECONDS.sleep(1);
        //playerInterface(p1,s,p1.getActualRoom());

        p1.showOptions();
        p1.move("field");
        field.addContainer(stone);

        p1.getLocation();
        p1.pickupFromContainer(stone);

        p1.showInventory();

        TimeUnit.SECONDS.sleep(1);
        p1.showOptions();
        p1.move("house");
        p1.getLocation();
        p1.putIntoContainer(cabinet, sword);
        cabinet.getContainerItems();


        TimeUnit.SECONDS.sleep(1);
        p1.showOptions();
        p1.move("roof");
        p1.getLocation();
        TimeUnit.SECONDS.sleep(1);



        System.out.println("You have finished the tutorial");


    }
}


