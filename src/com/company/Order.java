package com.company;

import java.util.HashMap;

public class Order{
    private static final int DRINK = 0;
    private static final String DRINK_DEFAULT_NAME = "Cola";
    private static final String DRINK_DEFAULT_DESCRIPTION = "cold drink";
    private static final int DISH = 1;
    private static final String DISH_DEFAULT_NAME = "BigMac";
    private static final String DISH_DEFAULT_DESCRIPTION = "beef burger";
    private HashMap<String, Item> difPositions;
    private HashMap<String, Integer> positionsCount;
    private int n;

    public Order() {
        difPositions = new HashMap<>();
        positionsCount = new HashMap<>();
        n = 0;
    }

    void add(int type){
        n++;
        switch (type){
            case DRINK:
                if (difPositions.containsKey(DRINK_DEFAULT_NAME)){
                    positionsCount.put(DRINK_DEFAULT_NAME, positionsCount.get(DRINK_DEFAULT_NAME) + 1);
                } else {
                    difPositions.put(DRINK_DEFAULT_NAME, new Drink(DRINK_DEFAULT_NAME, DRINK_DEFAULT_DESCRIPTION));
                    positionsCount.put(DRINK_DEFAULT_NAME, 1);
                }
                break;
            case DISH:
                if (difPositions.containsKey(DISH_DEFAULT_NAME)){
                    positionsCount.put(DISH_DEFAULT_NAME, positionsCount.get(DISH_DEFAULT_NAME) + 1);
                } else {
                    difPositions.put(DISH_DEFAULT_NAME, new Drink(DISH_DEFAULT_NAME, DISH_DEFAULT_DESCRIPTION));
                    positionsCount.put(DISH_DEFAULT_NAME, 1);
                }
                break;
            default:
                break;
        }
    }

    void remove(String position){
        if (positionsCount.containsKey(position)){
            if (positionsCount.get(position) <= 1){
                positionsCount.remove(position);
                difPositions.remove(position);
            } else{
                positionsCount.put(position, positionsCount.get(position) - 1);
            }
        }
    }

    boolean isEmpty(){
        return difPositions.isEmpty();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String position: difPositions.keySet()
             ) {
            res.append(position).append(' ');
            res.append(positionsCount.get(position)).append("\n");
        }
        return res.toString();
    }
}
