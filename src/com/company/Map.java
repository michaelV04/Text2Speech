package com.company;

import java.util.ArrayList;
import java.util.Objects;


public class Map {
    private final String name;
    private final int mapSize;
    private int pos;
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
            x.setPos(position);
        }else if(stage == 0){
            roomsS0.add(position, x);
            x.setPos(position);
        }else if(stage == 2){
            roomsS2.add(position, x);
            x.setPos(position);
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

    public int checkIfExitTrue(Room x,Room y,Map z){
        double add = Math.sqrt(mapSize);
        int intAdd = (int) add;
        for (int i = 0; i < mapSize; i++) {
            if (i == 0 && roomsS0.get(i) == x || i == 0 && roomsS1.get(i) == x || i == 0 && roomsS2.get(i) == x) {
                if (x == roomsS0.get(i)) {
                    if (roomsS0.get(i + 1) == y) {
                        return 1;
                    } else if (roomsS0.get(i + intAdd) == y) {
                        return 1;
                    }if(roomsS1.get(i) != null){
                        if (roomsS0.get(i).getPos() == roomsS1.get(i).getPos() && roomsS1.get(i) == y) {
                            return 1;
                        }
                    }
                } else if (x == roomsS1.get(i)) {
                    if (roomsS1.get(i + 1) == y) {
                        return 1;
                    } else if (roomsS1.get(i + intAdd) == y) {
                        return 1;
                    } if(roomsS0.get(i) != null){
                        if (roomsS0.get(i).getPos() == roomsS1.get(i).getPos() && roomsS0.get(i) == y) {
                            return 1;
                        }
                    }if (roomsS2.get(i) != null){
                        if (roomsS2.get(i).getPos() == roomsS1.get(i).getPos() && Objects.equals(roomsS2.get(0).getRoomName(), y.getRoomName())) {
                            return 1;
                        }
                    }

                } else if (x == roomsS2.get(i)) {
                    if (roomsS2.get(i + 1) == y) {
                        return 1;
                    } else if (roomsS2.get(i + intAdd) == y) {
                        return 1;
                    } if(roomsS1.get(i) != null){
                        if (roomsS1.get(i).getPos() == roomsS2.get(i).getPos() && roomsS1.get(i) == y) {
                            return 1;
                        }
                    }
                }
            }
                if (x == roomsS0.get(i)) {
                    if (roomsS0.get(i + 1) == y) {
                        return 1;
                    } else if (roomsS0.get(i - 1) == y) {
                        return 1;
                    } else if (roomsS0.get(i - intAdd) == y) {
                        return 1;
                    } else if (roomsS0.get(i + intAdd) == y) {
                        return 1;
                    } if(roomsS1.get(i) != null){
                        if (roomsS0.get(i).getPos() == roomsS1.get(i).getPos() && roomsS1.get(i) == y) {
                            return 1;
                        }
                    }
                } else if (x == roomsS1.get(i)) {
                    if (roomsS1.get(i + 1) == y) {
                        return 1;
                    } else if (roomsS1.get(i - 1) == y) {
                        return 1;
                    } else if (roomsS1.get(i - intAdd) == y) {
                        return 1;
                    } else if (roomsS1.get(i + intAdd) == y) {
                        return 1;
                    } if(roomsS0.get(i) != null){
                        if (roomsS0.get(i).getPos() == roomsS1.get(i).getPos() && roomsS0.get(i) == y) {
                            return 1;
                        }
                    }if (roomsS2.get(i) != null){
                        if (roomsS2.get(i).getPos() == roomsS1.get(i).getPos() && Objects.equals(roomsS2.get(0).getRoomName(), y.getRoomName())) {
                            return 1;
                        }
                    }
                } else if (x == roomsS2.get(i)) {
                    if (roomsS2.get(i + 1) == y) {
                        return 1;
                    } else if (roomsS2.get(i - 1) == y) {
                        return 1;
                    } else if (roomsS2.get(i - intAdd) == y) {
                        return 1;
                    } else if (roomsS2.get(i + intAdd) == y) {
                        return 1;
                    } if(roomsS1.get(i) != null){
                        if (roomsS1.get(i).getPos() == roomsS2.get(i).getPos() && roomsS1.get(i) == y) {
                            return 1;
                        }
                    }
                }
            }

            return 0;

    }

    public int getPos(){
        return pos;
    }

    public Room getRoom(int stage, int id){
        if (stage == 1){
            return roomsS1.get(id);
        }else if (stage == 2){
            return roomsS1.get(id);
        }else if (stage == 3){
            return roomsS1.get(id);
        }else{
            return null;
        }
    }





}
