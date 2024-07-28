package com.factory;

public interface Transport {
    void deliver();
    void setSpeed(int speed);
    void setCapacity(int capacity);
    int getSpeed();
    int getCapacity();
}
