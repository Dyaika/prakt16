package com.company;

public class Main {

    public static void main(String[] args) {

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
