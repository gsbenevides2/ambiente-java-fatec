package com.gsbenevides2.sanduiche;

public abstract class Sanduiche {
    String name;
    double price;

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void prepare() {
        System.out.println("Preparing " + name);
    }
    public void bake() {
        System.out.println("Baking " + name);
    }
    public void cut() {
        System.out.println("Cutting " + name);
    }
    public void box() {
        System.out.println("Boxing " + name);
    }
    public String toString() {
        return "Sanduiche: " + name + " \nPrice: $" + price;
    }
}
