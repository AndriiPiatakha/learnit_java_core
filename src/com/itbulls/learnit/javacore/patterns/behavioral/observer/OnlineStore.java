package com.itbulls.learnit.javacore.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    private List<Observer> observers = new ArrayList<>();
    
    private boolean isGoodsArrived;

    public void addListener(Observer o) {
        observers.add(o);
    }

    public boolean isGoodsArrived() {
        return isGoodsArrived;
    }

    public void setState(boolean isGoodsArrived) {
        this.isGoodsArrived = isGoodsArrived;
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}