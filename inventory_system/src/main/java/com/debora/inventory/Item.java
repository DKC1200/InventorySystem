package com.debora.inventory;

public class Item {

    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){ return name; }
    public double getPrice(){ return price; }
    public int getQuantity(){ return quantity; }

    public void setName(String input){ name = input; }
    public void setPrice(double input){ price = input; }
    public void setQuantity(int input){ quantity = input; }
}