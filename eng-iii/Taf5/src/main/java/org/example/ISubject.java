package org.example;

import java.util.Observable;
import java.util.ArrayList;
import java.util.List;

public class A extends Observable {}

public interface ISubject {
    List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifyObservers();
}
