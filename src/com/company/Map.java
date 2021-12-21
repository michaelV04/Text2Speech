package com.company;

import java.util.ArrayList;
import java.util.Objects;


public class Map {
    private String name;
    private int mapSize;
    private int pos;
    ArrayList<Room> roomsS1 = new ArrayList<>();
    ArrayList<Room> roomsS0 = new ArrayList<>();
    ArrayList<Room> roomsS2 = new ArrayList<>();


    public Map(String mapname, int mapSize) {
        this.name = mapname;
        this.mapSize = mapSize;
        for (int i = 0; i < mapSize+1; i++) {
            roomsS0.add(null);
            roomsS1.add(null);
            roomsS2.add(null);
        }
    }

    public String getName() {
        return name;
    }

    public void addRoom(Room x, int position, int stage) {
        if (stage == 1) {
            roomsS1.add(position, x);
            x.setPos(position);
        } else if (stage == 0) {
            roomsS0.add(position, x);
            x.setPos(position);
        } else if (stage == 2) {
            roomsS2.add(position, x);
            x.setPos(position);
        }
    }

    public void showMap() {
        System.out.println("Stage 2:");
        double divide = mapSize;
        divide = Math.sqrt(divide);
        for (int i = 0; i < mapSize; i++) {
            if (roomsS2.get(i) != null) {
                System.out.print(i+roomsS2.get(i).getRoomName() + "\t");
            }
            for (int j = 1; j < mapSize; j++) {
                if (i == divide*j) {
                    System.out.println("\n");
                }
            }
        }
        System.out.println("\n");
        System.out.println("Stage 1:");
        for (int i = 0; i < mapSize; i++) {
            if (roomsS1.get(i) != null) {
                System.out.print(i+roomsS1.get(i).getRoomName() + "\t");
            }
            for (int j = 1; j < mapSize; j++) {
                if (i == divide*j) {
                    System.out.println("\n");
                }
            }

        }
        System.out.println("\n");

        System.out.println("Stage 0:");
        for (int i = 0; i < mapSize; i++) {
            if (roomsS0.get(i) != null){
                System.out.print(i+roomsS0.get(i).getRoomName() + "\t");
            }
            for (int j = 1; j < mapSize; j++) {
                if (i == divide*j) {
                    System.out.println("\n");
                }
            }
        }
    }


//


    public int checkIfExitTrue(Room playerRoom,Room destinationRoom) {

            double add = Math.sqrt(mapSize);
            int intAdd = (int) add;
            for (int i = 0; i <= mapSize; i++) {
                if (roomsS1.get(i) != null || roomsS0.get(i) != null || roomsS2.get(i) != null) {
                    if (roomsS0.get(i) != null) {
                        if (i == 0 && Objects.equals(roomsS0.get(i).getRoomName(), playerRoom.getRoomName())) {
                            if (roomsS0.get(i + 1) != null) {
                                if (Objects.equals(roomsS0.get(i + 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getEastExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS0.get(i + intAdd) != null) {
                                if (Objects.equals(roomsS0.get(i + intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getSouthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS1.get(i) != null) {
                                if (roomsS0.get(i).getPos() == roomsS1.get(i).getPos() && Objects.equals(roomsS1.get(i).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getUpExitType() == 1) {
                                    return 1;
                                }
                            }
                        }
                    }
                    if (roomsS1.get(i) != null) {
                        if (i == 0 && Objects.equals(roomsS1.get(i).getRoomName(), playerRoom.getRoomName())) {
                            if (roomsS1.get(i + 1) != null) {
                                if (Objects.equals(roomsS1.get(i + 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getEastExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS1.get(i + intAdd) != null) {
                                if (Objects.equals(roomsS1.get(i + intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getSouthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS0.get(i) != null) {
                                if (roomsS0.get(i).getPos() == roomsS1.get(i).getPos() && Objects.equals(roomsS0.get(i).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getDownExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS2.get(i) != null) {
                                if (roomsS2.get(i).getPos() == roomsS1.get(i).getPos() && Objects.equals(roomsS2.get(0).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getUpExitType() == 1) {
                                    return 1;
                                }
                            }

                        }
                    }
                    if (roomsS2.get(i) != null) {
                        if (i == 0 && Objects.equals(roomsS2.get(i).getRoomName(), playerRoom.getRoomName())) {
                            if (roomsS2.get(i + 1) != null) {
                                if (Objects.equals(roomsS2.get(i + 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getEastExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS2.get(i + intAdd) != null) {
                                if (Objects.equals(roomsS2.get(i + intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getSouthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS1.get(i) != null) {
                                if (roomsS1.get(i).getPos() == roomsS2.get(i).getPos() && Objects.equals(roomsS1.get(i).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getDownExitType() == 1) {
                                    return 1;
                                }
                            }

                        }
                    }

                    if (roomsS0.get(i) != null) {
                        if (Objects.equals(playerRoom.getRoomName(), roomsS0.get(i).getRoomName())) {
                            if (roomsS0.get(i + 1) != null) {
                                if (Objects.equals(roomsS0.get(i + 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getEastExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS0.get(i - 1) != null) {
                                if (Objects.equals(roomsS0.get(i - 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getWestExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS0.get(i - intAdd) != null) {
                                if (Objects.equals(roomsS0.get(i - intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getNorthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS0.get(i + intAdd) != null) {
                                if (Objects.equals(roomsS0.get(i + intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getSouthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS1.get(i) != null) {
                                if (roomsS0.get(i).getPos() == roomsS1.get(i).getPos() && Objects.equals(roomsS1.get(i).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getUpExitType() == 1) {
                                    return 1;
                                }
                            }
                        }
                    }

                    if (roomsS1.get(i) != null) {
                        if (Objects.equals(playerRoom.getRoomName(), roomsS1.get(i).getRoomName())) {
                            if (roomsS1.get(i + 1) != null) {
                                if (Objects.equals(roomsS1.get(i + 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getEastExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS1.get(i - 1) != null) {
                                if (Objects.equals(roomsS1.get(i - 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getWestExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS1.get(i - intAdd) != null) {
                                if (Objects.equals(roomsS1.get(i - intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getNorthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS1.get(i + intAdd) != null) {
                                if (Objects.equals(roomsS1.get(i + intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getSouthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS0.get(i) != null) {
                                if (roomsS0.get(i).getPos() == roomsS1.get(i).getPos() && Objects.equals(roomsS0.get(i).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getDownExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS2.get(i) != null) {
                                if (roomsS2.get(i).getPos() == roomsS1.get(i).getPos() && Objects.equals(roomsS2.get(i).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getUpExitType() == 1) {
                                    return 1;
                                }
                            }
                        }
                    }

                    if (roomsS2.get(i) != null) {
                        if (Objects.equals(playerRoom.getRoomName(), roomsS2.get(i).getRoomName())) {
                            if (roomsS2.get(i + 1) != null) {
                                if (Objects.equals(roomsS2.get(i + 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getEastExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS2.get(i - 1) != null) {
                                if (Objects.equals(roomsS2.get(i - 1).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getWestExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS2.get(i - intAdd) != null) {
                                if (Objects.equals(roomsS2.get(i - intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getNorthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS2.get(i + intAdd) != null) {
                                if (Objects.equals(roomsS2.get(i + intAdd).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getSouthExitType() == 1) {
                                    return 1;
                                }
                            }
                            if (roomsS1.get(i) != null) {
                                if (roomsS1.get(i).getPos() == roomsS2.get(i).getPos() && Objects.equals(roomsS1.get(i).getRoomName(), destinationRoom.getRoomName()) && playerRoom.getDownExitType() == 1) {
                                    return 1;
                                }
                            }
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

    public int getMapSize(){
        return mapSize;
    }
    public void setMapSize(int mapSize){
        this.mapSize = mapSize;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setS2(ArrayList<Room> x){
        this.roomsS2 = x;
    }
    public ArrayList<Room> getS2(){
        return roomsS2;
    }
    public void setS0(ArrayList<Room> x){
        this.roomsS0 = x;
    }
    public ArrayList<Room> getS0(){
        return roomsS0;
    }
    public void setS1(ArrayList<Room> x){
        this.roomsS1 = x;
    }
    public ArrayList<Room> getS1(){
        return roomsS1;
    }





}
