package com.company;

public interface Order{
    boolean add(Item item);
    boolean removeOnce(String position);
    int removeAll(String position);
    int getAllPositionCount();
    Item[] getPositions();
    int getTotalPrice();
    int getPositionCount(String position);
    String[] getPositionNames();
    Item[] getPositionsSorted();
}
