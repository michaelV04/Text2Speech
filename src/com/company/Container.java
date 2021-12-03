package com.company;

import java.util.ArrayList;

public class Container {
    ArrayList<Item> dingeInside = new ArrayList<>();
    private String containerName;

    public Container(String name){
        this.containerName = name;
    }

    public void addThing(Item item) {
        dingeInside.add(item);
    }
    public boolean removeThing(Item item) {
        if(dingeInside.remove(item)) {
            return true;
        } else {
            return false;
        }
    }

    public String getContainerName(){
        return containerName;
    }

    public void getContainerItems(){
        for (int i = 0; i < dingeInside.size(); i++) {
            System.out.println(dingeInside.get(i).getItemName());
        }
    }
}
