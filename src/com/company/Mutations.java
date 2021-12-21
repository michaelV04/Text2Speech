package com.company;

/**
 * schaut ob mutation wahr oder falsch ist.
 */
public interface Mutations {

    boolean mutationX = false;
    boolean mutationY = false;
    boolean mutationZ = false;

    void mutationXuse(Item i);
    void mutationYuse(Item i);
    void mutationZuse(Item i);
}
