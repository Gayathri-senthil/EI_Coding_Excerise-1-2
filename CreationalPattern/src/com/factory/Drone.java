package com.factory;

public class Drone implements Transport {
    private int speed;
    private int capacity;

    @Override
    public void deliver() {
        System.out.println("Delivering by Drone.");
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}