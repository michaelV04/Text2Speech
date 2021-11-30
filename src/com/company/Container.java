package com.company;

import java.util.ArrayList;

public interface Container {
    ArrayList<Object> dingeInside = new ArrayList<>();

    public void addThing();
    public void removeThing();
}
