package com.company;

import java.util.HashMap;

public class TablesOrderManager {
    private HashMap<Integer, RestaurantOrder> tables;
    private static final int DRINK = 0;
    private static final int DISH = 1;
    private final int n;

    public TablesOrderManager(int n) {
        this.n = n;
        tables = new HashMap<>();
        for (int i = 1; i <= n; i++){
            tables.put(i, new RestaurantOrder());
        }
    }

    public void add(int table, int type){
        tables.get(table).add(type);
    }
    public void remove(int table, String position){
        tables.get(table).removeOnce(position);
    }
    public String getTable(int table){
        return tables.get(table).toString();
    }
    public static void test16(){
        int size = 4;
        TablesOrderManager tablesOrderManager = new TablesOrderManager(size);
        for (int i = 1; i <= size; i++){
            for (int j = 0; j < i - 1; j++){
                tablesOrderManager.add(i, 0);
            }
            for (int j = 0; j < size - i + 1; j++){
                tablesOrderManager.add(i, 1);
            }
        }

        for (int i = 1; i <= size; i++){
            System.out.println( i + ") " + tablesOrderManager.getTable(i));
        }

        tablesOrderManager.remove(3, "Cola");
        tablesOrderManager.remove(3, "Cola");
        tablesOrderManager.remove(3, "BigMac");
        System.out.println("After removing 2 cola and 1 bigmac from table 3:");
        for (int i = 1; i <= size; i++){
            System.out.println( i + ") " + tablesOrderManager.getTable(i));
        }
    }
}
