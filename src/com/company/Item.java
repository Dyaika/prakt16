package com.company;

public interface Item {
    int getPrice();
    String getName();
    String getDescription();
    int compareTo(Item item);
}
