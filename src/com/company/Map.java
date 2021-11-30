package com.company;

import java.util.ArrayList;


public class Map {
    private String name;
    private int mapSize;
    ArrayList<Room> roomsS1 = new ArrayList<>();
    ArrayList<Room> roomsS0 = new ArrayList<>();
    ArrayList<Room> roomsS2 = new ArrayList<>();


    public Map(String mapname,int mapSize){
        this.name = mapname;
        this.mapSize = mapSize;
        for (int i = 0; i < 64; i++) {
            roomsS0.add(null);
            roomsS1.add(null);
            roomsS2.add(null);
        }
    }
    public String getName(){
        return name;
    }

    public void addRoom(Room x,int position,int stage){
        if (stage == 1) {
            roomsS1.add(position, x);
        }else if(stage == 0){
            roomsS0.add(position, x);
        }else if(stage == 2){
            roomsS2.add(position, x);
        }
    }

    public void showMap(){
        for (int i = 0; i < mapSize; i = i+2) {
            System.out.print(roomsS2.get(i)+"\t");
            System.out.println(roomsS2.get(i+1));

        }
        System.out.println("\n");
        for (int i = 0; i < mapSize; i = i+2) {
            System.out.print(roomsS1.get(i)+"\t");
            System.out.println(roomsS1.get(i+1));

        }
        System.out.println("\n");
        for (int i = 0; i < mapSize; i = i+2) {
            System.out.print(roomsS0.get(i)+"\t");
            System.out.println(roomsS0.get(i+1));

        }
        System.out.println("\n\n\n\n\n");
    }

    public int checkIfExitTrue(Room x,Room y){
        double add = Math.sqrt(mapSize);
        int intAdd = (int) add;
        for (int i = 0; i < mapSize; i++) {
            if (x == roomsS0.get(i)){
                if (roomsS0.get(i+1) == y){
                    return 1;
                }else if(roomsS0.get(i-1)==y){
                    return 1;
                } else if(roomsS0.get(i-intAdd)==y){
                    return 1;
                }else if(roomsS0.get(i+intAdd)==y){
                    return 1;
                }else if(roomsS0.get(i)==roomsS1.get(i) && roomsS1.get(i) == y){
                    return 1;
                }
            }else if(x == roomsS1.get(i)){
                if (roomsS1.get(i+1) == y){
                    return 1;
                }else if(roomsS1.get(i-1)==y){
                    return 1;
                } else if(roomsS1.get(i-intAdd)==y){
                    return 1;
                }else if(roomsS1.get(i+intAdd)==y){
                    return 1;
                }else if(roomsS1.get(i)==roomsS0.get(i) && roomsS0.get(i) == y){
                    return 1;
                }else if(roomsS1.get(i)==roomsS2.get(i) && roomsS2.get(i) == y){
                    return 1;
                }
            }else if(x == roomsS2.get(i)){
                if (roomsS2.get(i+1) == y){
                    return 1;
                }else if(roomsS2.get(i-1)==y){
                    return 1;
                } else if(roomsS2.get(i-intAdd)==y){
                    return 1;
                }else if(roomsS2.get(i+intAdd)==y){
                    return 1;
                }else if(roomsS2.get(i)==roomsS1.get(i) && roomsS1.get(i) == y){
                    return 1;
                }
            }
        }

        return 0;
    }



}
