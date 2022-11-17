package com.company;

import java.util.HashMap;

public class TablesOrderManager {
    private HashMap<Integer, Order> tables;
    private static final int DRINK = 0;
    private static final int DISH = 1;
    private final int n;

    public TablesOrderManager(int n) {
        this.n = n;
        tables = new HashMap<>();
        for (int i = 1; i <= n; i++){
            tables.put(i, new Order());
        }
    }

    public void add(int table, int type){
        tables.get(table).add(type);
    }
    public void remove(int table, String position){
        tables.get(table).remove(position);
    }
    public String getTable(int table){
        return tables.get(table).toString();
    }
}
