package com.factory;

public class TransportFactory {
    public Transport getTransport(String transportType) {
        if (transportType == null) {
            return null;
        }
        switch (transportType.toUpperCase()) {
            case "TRUCK":
                return new Truck();
            case "SHIP":
                return new Ship();
            case "PLANE":
                return new Plane();
            case "TRAIN":
                return new Train();
            case "DRONE":
                return new Drone();
            default:
                return null;
        }
    }
}
