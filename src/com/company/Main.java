package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Player p1 = new Player("Goat", 100, 10, 10, 0, 1, 100);
        //createCharakter(p1,s);
        //playerInterface(p1,s);
        tutorialMap();

        // helo im main();



    }
    public static void createCharakter(Player p1,Scanner s){
        System.out.println("Wake up!");
        System.out.println("*You are standing between a river*");
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

    public static void playerInterface(Player p1,Scanner s){
        System.out.println("Welcome to the Player Interface.");
        System.out.println("You can move your Character by typing *move* then you will get a List of options");
        System.out.println("You can also look around the area your standing in with *look*");

        String command;
        System.out.println("What do you want to do?");
        command = s.next();

        if (Objects.equals(command, "look")){
            p1.searchRoom();
        }else if(Objects.equals(command, "move")){
            p1.move(river,tutorial);
        }

    }

    public static void tutorialMap(){
        Map tutorial = new Map("tutorial");
        Room river = new Room("river",0,0,0,1);
        Room field = new Room("field",1,0,1,0);
        Room house = new Room("house",0,1,0,0);


        tutorial.addRoom(river,4);
        tutorial.addRoom(field,3);
        tutorial.addRoom(house,1);

        tutorial.showMap();

        //-1 south   +1 north  +2west  -2south  +3up -3 down




    }
}


