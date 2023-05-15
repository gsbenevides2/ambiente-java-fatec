package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("I am going to to Small Potato Store...");
        PotatoStore smallPotatoStore = new  StoreSmallPotato();
        System.out.println("I will order a small potato...");
        Potato mySmallPotato = smallPotatoStore.orderPotato();
        System.out.println("My small potato contains: " + mySmallPotato);

        System.out.println("Now! I am going to Big Potato Store to order a big potato!");
        PotatoStore bigPotatoStore = new BigPotatoStore();
        Potato myBigPotato = bigPotatoStore.orderPotato();
        System.out.println("My big potato contains: " + myBigPotato);


    }
}