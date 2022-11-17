package com.company;

import java.util.HashMap;

public class RestaurantOrder implements Order{
    private static final int DRINK = 0;
    private static final String DRINK_DEFAULT_NAME = "Cola";
    private static final String DRINK_DEFAULT_DESCRIPTION = "cold drink";
    private static final int DISH = 1;
    private static final String DISH_DEFAULT_NAME = "BigMac";
    private static final String DISH_DEFAULT_DESCRIPTION = "beef burger";
    private HashMap<String, Item> difPositions;
    private HashMap<String, Integer> positionsCount;

    public RestaurantOrder() {
        difPositions = new HashMap<>();
        positionsCount = new HashMap<>();
    }

    @Override
    public boolean add(Item item) {
        if (difPositions.containsKey(item.getName())){
            positionsCount.put(item.getName(), positionsCount.get(item.getName()) + 1);
        } else {
            difPositions.put(item.getName(), item);
            positionsCount.put(item.getName(), 1);
        }
        return true;
    }

    @Override
    public boolean removeOnce(String position) {
        if (positionsCount.containsKey(position)){
            if (positionsCount.get(position) <= 1){
                positionsCount.remove(position);
                difPositions.remove(position);
            } else{
                positionsCount.put(position, positionsCount.get(position) - 1);
            }
            return true;
        }
        return false;
    }

    @Override
    public int removeAll(String position) {
        int res = 0;
        if (difPositions.containsKey(position)) {
            res = positionsCount.get(position);
            difPositions.remove(position);
            positionsCount.remove(position);
        }
        return res;
    }

    @Override
    public int getAllPositionCount() {
        int res = 0;
        for (int i: positionsCount.values()
             ) {
            res += i;
        }
        return res;
    }

    @Override
    public Item[] getPositions() {
        int size = difPositions.keySet().size();
        Item[] res = new Item[size];
        int i = 0;
        for (Item item: difPositions.values()
             ) {
            res[i] = item;
            i++;
        }
        return res;
    }

    @Override
    public int getTotalPrice() {
        int sum = 0;
        for (Item item:
             difPositions.values()) {
            sum += item.getPrice() * positionsCount.get(item.getName());
        }
        return sum;
    }

    @Override
    public int getPositionCount(String position) {
        if (difPositions.containsKey(position)){
            return positionsCount.get(position);
        }
        return 0;
    }

    @Override
    public String[] getPositionNames() {
        int size = difPositions.keySet().size();
        String[] res = new String[size];
        int i = 0;
        for (Item item: difPositions.values()
        ) {
            res[i] = item.getName();
            i++;
        }
        return res;
    }

    @Override
    public Item[] getPositionsSorted() {
        Item[] res = getPositions();
        int n = res.length;
        Item cur = res[0];
        for (int i = 1; i < n; i++){
            cur = res[i];
            int j = i - 1;
            while (j >= 0 && cur.compareTo(res[j]) < 0){
                res[j + 1] = res[j];
                j--;
            }
            res[j+1] = cur;
        }
        return res;
    }

    void add(int type){
        Item item;
        switch (type){
            case DRINK:
                item = new Drink(DRINK_DEFAULT_NAME, DRINK_DEFAULT_DESCRIPTION);
                add(item);
                break;
            case DISH:
                item = new Dish(DISH_DEFAULT_NAME, DISH_DEFAULT_DESCRIPTION);
                add(item);
                break;
            default:
                break;
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
            res.append(positionsCount.get(position)).append(' ');
            res.append(difPositions.get(position).getPrice()).append("$\n");
        }
        return res.toString();
    }

    public static void test17(){
        Order order = new RestaurantOrder();
        order.add(new Drink(12, "Cola", "from Kazakhstan"));
        order.add(new Drink(12, "Cola", "from Kazakhstan"));
        order.add(new Drink(12, "Fanta", "from Kazakhstan"));
        order.add(new Drink(12, "Fanta", "from Kazakhstan"));
        for (int i = 0; i < 3; i++){
            order.add(new Drink((int)Math.abs(Math.random() * 100), "Drink_" + i, "from Kazakhstan"));
            order.add(new Dish((int)Math.abs(Math.random() * 100), "Dish_" + i, "from Kazakhstan"));
        }
        System.out.println("All positions:");
        for (Item i:
             order.getPositions()) {
            System.out.println(i.getName() + "\t" + i.getPrice() + "$\t" + order.getPositionCount(i.getName()));
        }

        order.removeAll("Cola");
        order.removeOnce("Fanta");
        System.out.println("\nAfter deleting all cola and 1 fanta (sorted by price):");
        for (Item i:
                order.getPositionsSorted()) {
            System.out.println(i.getName() + "\t" + i.getPrice() + "$\t" + order.getPositionCount(i.getName()));
        }

        System.out.println("\n As string array:");
        for (String s:
             order.getPositionNames()) {
            System.out.println(s);
        }

        System.out.println("Total price: " + order.getTotalPrice() + "$");
    }
}
