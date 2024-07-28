package com.factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransportFactory transportFactory = new TransportFactory();
        Scanner scanner = new Scanner(System.in);
        Transport transport = null;

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Enter the type of transport to use (TRUCK, SHIP, PLANE, TRAIN, DRONE): ");
                    String transportType = scanner.nextLine().toUpperCase();
                    transport = transportFactory.getTransport(transportType);
                    if (transport != null) {
                        System.out.println(transportType + " created.");
                    } else {
                        System.out.println("Invalid transport type.");
                    }
                    break;
                case "2":
                    if (transport != null) {
                        System.out.println("Enter speed: ");
                        int speed = Integer.parseInt(scanner.nextLine());
                        transport.setSpeed(speed);
                        System.out.println("Enter capacity: ");
                        int capacity = Integer.parseInt(scanner.nextLine());
                        transport.setCapacity(capacity);
                        System.out.println("Properties set.");
                    } else {
                        System.out.println("No transport selected.");
                    }
                    break;
                case "3":
                    if (transport != null) {
                        transport.deliver();
                    } else {
                        System.out.println("No transport selected.");
                    }
                    break;
                case "4":
                    if (transport != null) {
                        System.out.println("Transport Details:");
                        System.out.println("Speed: " + transport.getSpeed());
                        System.out.println("Capacity: " + transport.getCapacity());
                    } else {
                        System.out.println("No transport selected.");
                    }
                    break;
                case "5":
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Transport Factory ---");
        System.out.println("1. Create Transport");
        System.out.println("2. Set Transport Properties");
        System.out.println("3. Deliver");
        System.out.println("4. View Transport Details");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}
