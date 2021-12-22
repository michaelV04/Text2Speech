package com.company;

import java.util.ArrayList;

public class Container {
    ArrayList<Item> dingeInside = new ArrayList<>();
    private final String containerName;

    /**
     * setzt Parameter
     * @param name name
     */
    public Container(String name){
        this.containerName = name;
    }

    /**
     * @param item Item
     * ein Item wird in den Container gegeben
     */
    public void addThing(Item item) {
        dingeInside.add(item);
    }

    /**
     * Item wird aus Container entfernt
     * @param item Item
     * @return Item
     */
    public boolean removeThing(Item item) {
        if(dingeInside.remove(item)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return Container Name
     */
    public String getContainerName(){
        return containerName;
    }

    /**
     Item im Container werden ausgegeben
     */
    public void getContainerItems(){
        for (Item item : dingeInside) {
            System.out.println(item.getItemName());
        }
    }
}
