package com.company;

public final class Drink implements Item{
    private static final int DEFAULT_PRICE = 0;
    private int price;
    private String name;
    private String description;

    public Drink(int price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Drink(String name, String description) {
        this.price = DEFAULT_PRICE;
        this.name = name;
        this.description = description;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Item item) {
        if (getPrice() == item.getPrice()) {
            return getName().compareTo(item.getName());
        } else if (getPrice() > item.getPrice()){
            return 1;
        } else {
            return -1;
        }
    }

}
