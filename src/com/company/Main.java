package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    /**
     * Erzeugt einen Scanner und ruft die funktion mainlobby auf und übergibt den scanner
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        //combatTest(s);
        mainLobby(s);
    }

    /**
     *
     * @param s scanner
     * Startet das tutorial und wartet darauf dass es fertig wird dann wird der benutzer gefragt ob er tutorial, bug break, commands oder das spiel beenden will.
     */
    public static void mainLobby(Scanner s) throws InterruptedException {
        tutorial(s);
        int x = 0;
        while (x == 0) {
            int eingabe;
            System.out.println("\t\t\t Bug Break");
            System.out.println("Tutorial = 1\nMain Story = 2\nCommands and Shortcuts you can also open it in game by typing commands = 3\nClose the Game = 4");
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

    /**
     * @param s scanner
     * Erstellt eine Map und speichert einen room hinein, im room werden zwei zombies erstellt und ein player. Dannach kämpft der speiler gegen die zombies bis er stirb oder sie.
     */
    public static void combatTest(Scanner s) {
        int alive = 1;
        Map testM1 = new Map("testM1",9);
        Room testR1 = new Room("testR1","ulala",0,0,0,1,0,0);
        Mob zombie = new Mob("zombie1",1000,10,0,0,1,50,testR1,testM1,1);
        Mob zombie1 = new Mob("zombie2",1000,10,0,0,1,50,testR1,testM1,1);
        Item mobitem1 = new Item("x",0,10,0,0,0);
        zombie.pickupItem(mobitem1);
        testM1.addRoom(testR1,0,0);
        testR1.addMob(zombie1);
        testR1.addItem(mobitem1);

        testR1.addMob(zombie);
        Player p1 = new Player("Hans",100,100,0,30,100,100,testR1,testM1);
        while (alive == 1) {
            alive = p1.combat("zombie1");
            p1.searchRoom(p1.actualRoom);
        }

    }

    /**
     * Listet die Befehle auf
     */
    public static void commands() {
        System.out.println("You can move your Character by typing *move* then you will get a List of options");
        System.out.println("You can also look around the area your standing in with *look*\nOr fight a Mob with combat\nOr look at your stats");
        System.out.println("You can Exit the game with exit and with inv you can open your Inventory\nWith finish you can check if you have finished the game");
    }

    /**
     * ruft die funktion bugBreak auf
     * @param s scanner
     */
    public static void bugBreak(Scanner s) {
        startVillage(s);
    }

    /**
     * erstellt eine Karte woodsstartVillage mit raeumen mobs Spieler contaier und items dannach wird die funktion player interface aufgerufen.
     * @param s scanner
     */
    public static void startVillage(Scanner s) {
        Map woodsStartVillage = new Map("Start_Village",256);
        Room woods1 = new Room("woods1","A dark place with trees nothing else to see",0,0,1,0,0,0); // ok
        Room woods2 = new Room("woods2","A dark place with trees nothing else to see",0,0,1,1,0,0); // ok
        Room woods3 = new Room("woods3","A dark place with trees but something is glowing nearby",0,0,1,1,0,0); // ok
        Room woods4 = new Room("woods4","A dark place with trees nothing else to see",0,0,1,1,0,0); // ok
        Room cliff1 = new Room("cliff1","Theres a waterfall falling of the cliff ending in a sea",0,0,1,1,0,0); // ok
        Room sea1 = new Room("sea1","You have to swim to the other side",0,0,1,1,0,0); // ok

        Room village_Entrance1 = new Room("Village_Entrance1","A gate protected by guards",0,0,1,1,0,0); // ok

        Room village_Road1 = new Room("Village_Road1","No one to see you can hear soldiers talking",0,1,1,0,0,0); // ok
        Room village_Road2 = new Room("Village_Road2","No one to see you can hear soldiers talking",1,1,0,0,0,0); // ok
        Room village_Road3 = new Room("Village_Road3","No one to see you can hear soldiers talking",1,1,1,1,0,0); // ok
        Room village_Road4 = new Room("Village_Road4","No one to see you can hear soldiers talking",1,1,0,0,0,0); // ok
        Room village_Road5 = new Room("Village_Road5","No one to see you can hear soldiers talking",1,0,1,0,0,0); // ok
        Room village_Road6 = new Room("Village_Road6","Soldiers are here",0,0,1,1,0,0); // ok
        Room village_Road7 = new Room("Village_Road7","Soldiers are here",1,0,1,1,0,0); // ok
        Room village_Road8 = new Room("Village_Road8","Soldiers are here",0,0,1,1,0,0); // ok
        Room village_Road9 = new Room("Village_Road9","No one to see you can hear soldiers talking",0,1,1,1,0,0); // ok
        Room village_Road10 = new Room("Village_Road10","No one to see you can hear soldiers talking",1,1,0,0,0,0); // ok
        Room village_Road11 = new Room("Village_Road11","No one to see you can hear soldiers talking",1,1,1,1,0,0); // ok
        Room village_Road12 = new Room("Village_Road12","No one to see you can hear soldiers talking",0,0,1,1,0,0); // ok
        Room village_Road13 = new Room("Village_Road13","No one to see you can hear soldiers talking",0,0,1,1,0,0); // ok
        Room village_Road14= new Room("Village_Road14","Soldiers are here",1,0,1,1,0,0); // ok
        Room village_Road15 = new Room("Village_Road15","No one to see you can hear soldiers talking",0,0,1,1,0,0); // ok
        Room village_Road16 = new Room("Village_Road16","No one to see you can hear soldiers talking",0,0,1,1,0,0); // ok
        Room village_Road17 = new Room("Village_Road17","No one to see you can hear soldiers talking",0,1,1,1,0,0); // ok
        Room village_Road18 = new Room("Village_Road18","No one to see you can hear soldiers talking",1,1,1,0,0,0); // ok
        Room village_Road19 = new Room("Village_Road19","No one to see you can hear soldiers talking",1,0,1,1,0,0); // ok
        Room village_Road20 = new Room("Village_Road20","No one to see you can hear soldiers talking",0,1,1,1,0,0); // ok
        Room village_Road21 = new Room("Village_Road21","No one to see you can hear soldiers talking",1,1,0,1,0,0); // ok
        Room village_Road22 = new Room("Village_Road22","Soldiers are here",1,1,1,1,0,0); // ok
        Room village_Road23 = new Room("Village_Road23","No one to see you can hear soldiers talking",1,1,1,1,0,0); // ok
        Room village_Road24 = new Room("Village_Road24","No one to see you can hear soldiers talking",1,0,0,1,0,0); // ok
        Room village_Road25 = new Room("Village_Road25","No one to see you can hear soldiers talking",1,1,0,1,0,0); // ok
        Room village_Road26 = new Room("Village_Road26","No one to see you can hear soldiers talking",1,1,0,1,0,0); // ok
        Room village_Road27 = new Room("Village_Road27","Soldiers are here",1,1,0,1,0,0); // ok

        Room house1 = new Room("house1","Looks destroyed",0,1,0,0,0,1); // ok
        Room house2 = new Room("house2","Looks destroyed",0,0,1,0,1,0); // ok
        Room house3 = new Room("house3","Looks destroyed",1,0,0,0,1,0); // ok
        Room house4 = new Room("house4","Looks destroyed",0,0,0,1,0,0); // ok
        Room house5 = new Room("house5","Looks destroyed",0,1,1,0,1,0); // ok
        Room house6 = new Room("house6","Looks destroyed",1,0,0,0,0,1); // ok

        Room church1 = new Room("church1","Climb it now!!",0,0,0,1,1,0); // ok
        Room church_top1 = new Room("church_Top1","Its windy up here",0,0,0,0,0,1); // ok

        Room house1_underground = new Room("house1_underground","Hard to see in here",0,0,0,0,1,0); // ok
        Room house6_underground = new Room("house6_underground","This Creature looks dangerous",0,0,0,0,1,0); // ok

        Room house2_2ndFloor = new Room("house2_2ndFloor","Looks shaby",0,0,1,0,0,1); // ok
        Room house3_2ndFloor = new Room("house3_2ndFloor","Looks shaby",0,0,0,1,0,1); // ok

        Room plateu_low = new Room("plateu_low","You can climb it",0,1,0,1,1,0); // ok
        Room plateu_high = new Room("plateu_high","Wow that is high",0,0,0,0,0,1); // ok

        Mob guard1 = new Mob("Guard1",400,50,10,0,50,300,village_Entrance1,woodsStartVillage,1);
        Mob guard2 = new Mob("Guard2",400,50,10,0,50,300,village_Entrance1,woodsStartVillage,1);
        Mob guard3 = new Mob("Guard3",200,50,10,0,50,600,village_Entrance1,woodsStartVillage,1);
        Mob guard4 = new Mob("Guard4",400,50,10,0,50,300,village_Road7,woodsStartVillage,1);
        Mob guard5 = new Mob("Guard5",400,50,10,0,50,300,village_Road7,woodsStartVillage,1);
        Mob guard6 = new Mob("Guard6",500,50,10,0,50,300,village_Road6,woodsStartVillage,1);
        Mob guard7 = new Mob("Guard7",500,50,10,0,50,300,village_Road6,woodsStartVillage,1);
        Mob guard8 = new Mob("Guard8",100,50,10,0,50,300,village_Road8,woodsStartVillage,1);
        Mob guard9 = new Mob("Guard9",100,50,10,0,50,300,village_Road8,woodsStartVillage,1);
        Mob guard10 = new Mob("Guard10",1000,70,20,0,50,500,village_Road14,woodsStartVillage,1);
        Mob guard11 = new Mob("Guard11",1000,70,20,0,50,500,village_Road14,woodsStartVillage,1);
        Mob guard12 = new Mob("Guard12",1000,70,20,0,50,500,village_Road14,woodsStartVillage,1);
        Mob guard13 = new Mob("Guard13",1000,30,100,0,50,300,village_Road22,woodsStartVillage,1);
        Mob guard14 = new Mob("Guard14",1000,30,100,0,50,300,village_Road22,woodsStartVillage,1);
        Mob guard15 = new Mob("Guard15",100,500,10,0,50,1000,plateu_high,woodsStartVillage,1);
        Mob guard16 = new Mob("Guard16",100,500,10,0,50,1000,plateu_high,woodsStartVillage,1);
        Mob guard17 = new Mob("Guard17",100,50,10,0,50,300,village_Road27,woodsStartVillage,1);
        Mob guard18 = new Mob("Guard18",100,50,10,0,50,300,village_Road27,woodsStartVillage,1);
        Mob guard19 = new Mob("Guard19",100,50,10,0,50,300,village_Road27,woodsStartVillage,1);
        Mob whiteSpike = new Mob("WhiteSpike",1000,500,50,90,100,400,house6_underground,woodsStartVillage,1);

        Container chest1 = new Container("Chest1");

        Item mutationX = new Item("Blue_Balls",0,0,0,0,0);
        Item mutationY = new Item("Martini",0,0,0,0,0);
        Item mutationZ = new Item("Gods_Piss",0,0,0,0,0);


        Player p1 = new Player("Hans",100,10,0,0,1,100,village_Road14,woodsStartVillage);
        //create Map
        //Row 1
        woodsStartVillage.addRoom(village_Road1,23,1);

        woodsStartVillage.addRoom(village_Road6,24,1);
        village_Road6.addMob(guard6);
        village_Road6.addMob(guard7);

        woodsStartVillage.addRoom(village_Road9,25,1);
        woodsStartVillage.addRoom(village_Road13,26,1);
        woodsStartVillage.addRoom(village_Road16,27,1);
        woodsStartVillage.addRoom(village_Road20,28,1);
        woodsStartVillage.addRoom(plateu_low,29,1);
        woodsStartVillage.addRoom(plateu_high,29,2);
        plateu_high.addItem(mutationY);
        plateu_high.addMob(guard15);
        plateu_high.addMob(guard16);
        Container chest2 = new Container("Chest2");
        Item Black_Bow1 = new Item("Black_Bow1",0,700,8,-8,50);
        chest2.addThing(Black_Bow1);
        plateu_high.addContainer(chest2);

        //Row 2
        woodsStartVillage.addRoom(village_Road2,39,1);

        woodsStartVillage.addRoom(house1,40,1);
        Mob villager1 = new Mob("villager1",100,1,0,0,1,10,house1,woodsStartVillage,0);
        house1.addMob(villager1);
        villager1.pickupItem(mutationX);

        woodsStartVillage.addRoom(house1_underground,40,0);
        Item Potato1 = new Item("Potato1",30,0,0,0,0);
        house1_underground.addItem(Potato1);

        woodsStartVillage.addRoom(village_Road10,41,1);
        woodsStartVillage.addRoom(house5,42,1);
        woodsStartVillage.addRoom(church1,43,1);
        woodsStartVillage.addRoom(church_top1,43,2);
        Item teleport_Stone = new Item("teleport_Stone",0,0,0,0,0);
        church_top1.addItem(teleport_Stone);

        woodsStartVillage.addRoom(village_Road21,44,1);
        woodsStartVillage.addRoom(village_Road25,45,1);

        //Row 3
        //woods
        woodsStartVillage.addRoom(woods1,48,1);
        woodsStartVillage.addRoom(woods2,49,1);
        woodsStartVillage.addRoom(woods3,50,1);
        woodsStartVillage.addRoom(woods4,51,1);
        woodsStartVillage.addRoom(cliff1,52,1);
        woodsStartVillage.addRoom(sea1,53,1);

        woods3.addContainer(chest1);
        Item Black_Katana1 = new Item("Black_Katana1",0,300,0,40,200);
        Item Dark_Armor1 = new Item("Dark_Armor",40,0,99,1,-10);
        Item Speed_Obelisk1 = new Item("Speed_Obelisk",0,0,0,0,400);
        chest1.addThing(Black_Katana1);
        chest1.addThing(Dark_Armor1);
        chest1.addThing(Speed_Obelisk1);

        //village
        woodsStartVillage.addRoom(village_Entrance1,54,1);
        village_Entrance1.addMob(guard1);
        village_Entrance1.addMob(guard2);
        village_Entrance1.addMob(guard3);

        woodsStartVillage.addRoom(village_Road3,55,1);

        woodsStartVillage.addRoom(village_Road7,56,1);
        village_Road7.addMob(guard4);
        village_Road7.addMob(guard5);

        woodsStartVillage.addRoom(village_Road11,57,1);

        woodsStartVillage.addRoom(village_Road14,58,1);
        village_Road14.addMob(guard10);
        village_Road14.addMob(guard11);
        village_Road14.addMob(guard12);

        woodsStartVillage.addRoom(village_Road17,59,1);

        woodsStartVillage.addRoom(village_Road22,60,1);
        village_Road22.addMob(guard13);
        village_Road22.addMob(guard14);

        woodsStartVillage.addRoom(village_Road26,61,1);

        //Row 4
        woodsStartVillage.addRoom(village_Road4,71,1);
        woodsStartVillage.addRoom(house2,72,1);
        woodsStartVillage.addRoom(house2_2ndFloor,72,2);
        Container chest3 = new Container("chest3");
        Item black_potion1 = new Item("black_Potion1",100,100,10,50,100);
        chest3.addThing(black_potion1);
        house2_2ndFloor.addContainer(chest3);

        woodsStartVillage.addRoom(house3,73,1);
        woodsStartVillage.addRoom(house3_2ndFloor,73,2);
        Item green_potion1 = new Item("green_Potion1",-100,-100,-10,-50,-100);
        Container chest4 = new Container("chest4");
        chest4.addThing(green_potion1);
        house2_2ndFloor.addContainer(chest4);

        woodsStartVillage.addRoom(house4,74,1);
        woodsStartVillage.addRoom(village_Road18,75,1);
        woodsStartVillage.addRoom(village_Road23,76,1);
        woodsStartVillage.addRoom(village_Road27,77,1);
        village_Road27.addMob(guard17);
        village_Road27.addMob(guard18);
        village_Road27.addMob(guard19);

        //Row 5
        woodsStartVillage.addRoom(village_Road5,87,1);
        woodsStartVillage.addRoom(village_Road8,88,1);
        village_Road8.addMob(guard8);
        village_Road8.addMob(guard9);

        woodsStartVillage.addRoom(village_Road12,89,1);
        woodsStartVillage.addRoom(village_Road15,90,1);
        woodsStartVillage.addRoom(village_Road19,91,1);
        woodsStartVillage.addRoom(village_Road24,92,1);
        woodsStartVillage.addRoom(house6,92,1);
        woodsStartVillage.addRoom(house6_underground,92,0);
        house6_underground.addMob(whiteSpike);
        house6_underground.addItem(mutationZ);


        woodsStartVillage.showMap();
        playerInterface(p1,s);

    }

    /**
     * der user kann auswählen zwischen Warrior Assassin und Tank dann werden die stats des player angepasst.
     * @param p1 Player
     * @param s scanner
     */
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

    /**
     * Listet alle Befehle auf dann kommt man in eine schleife in der man alle befehle ausführen kann und die aktuelle map spielen kann bis man stirbt oder man die map abschließt.
     * @param p1 Player
     * @param s scanner
     */
    public static void playerInterface(Player p1,Scanner s){
        System.out.println("Welcome to the Player Interface.");
        System.out.println("You can move your Character by typing *move* then you will get a List of options");
        System.out.println("You can also look around the area your standing in with *look*");
        System.out.println("You can move your Character by typing *move* then you will get a List of options");
        System.out.println("You can also look around the area your standing in with *look*\nOr fight a Mob with combat\nOr look at your stats");
        System.out.println("You can Exit the game with exit and with inv you can open your Inventory\nWith finish you can check if you have finished the game");
        int xy = 0;
        int alive = 1;
        while (xy == 0 && alive == 1) {
            String command;
            command = s.next();
            //
            if (Objects.equals(command, "look")) {
                p1.searchRoom(p1.actualRoom);
            } else if (Objects.equals(command, "move")) {
                p1.actualMap.showMap();
                System.out.println("In which Room would you like to move?");
                System.out.println("You are in Room " + p1.actualRoom.getRoomName());
                String e;
                e = s.next();
                alive = p1.move(e,alive);
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
                            alive = p1.combat(e);
                        }
                    }
                }

            }else if(Objects.equals(command, "exit")){
                xy++;
            }else if (Objects.equals(command, "inv")){
                p1.showInventory();
            }else if (Objects.equals(command, "command")){
                commands();
            }else if (Objects.equals(command, "stats")){
                p1.showStats();
            }
            else if (Objects.equals(p1.actualMap.getName(), "tutorial")){
                if (Objects.equals(p1.actualRoom.getRoomName(), "roof") && Objects.equals(p1.actualMap.roomsS1.get(0).containerInRoom.get(0).dingeInside.get(0).getItemName(), "sword")) {
                    System.out.println("You have finished the tutorial!");
                    xy++;
                }
            }else if(Objects.equals(p1.actualMap.getName(), "Start_Village")){
                for (int i = 0; i < p1.inventory.size(); i++) {
                    if (Objects.equals(p1.inventory.get(i).getItemName(), "teleport_Stone")){
                        System.out.println("Your body starts to dissolve");
                        System.out.println("Your entering a worm-hole");
                        System.out.println("Suddenly the worm-hole breaks");
                        xy++;
                    }
                }
            }
        }


    }

    /**
     * Erstellt eine Map tutorial und ruft dann die funktion player interface aud.
     * @param s
     * @throws InterruptedException
     */
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

        Mob m1 = new Mob("zombie", 20, 1000,0, 1,1,1,house,tutorial,1);
        m1.setRoom(house);
        house.mobsInRoom.add(m1);

        tutorial.showMap();

        System.out.println("Wake up!");
        System.out.println("*You are standing between a river*");
        System.out.println("Your Goal is to find the SWORD then to put it into the CABINET and then to go to the ROOF");

        p1.setRoom(river);
        createCharacter(p1,s);
        //a


        TimeUnit.SECONDS.sleep(1);
        playerInterface(p1,s);

        System.out.println("You died");


    }
}


