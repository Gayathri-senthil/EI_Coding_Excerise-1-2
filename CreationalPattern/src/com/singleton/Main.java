package com.singleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("7")) {
                break;
            }

            ConfigurationManager configManager = ConfigurationManager.getInstance();

            switch (command) {
                case "1":
                    LogisticsManager logisticsManager = new LogisticsManager();
                    logisticsManager.printConfiguration();
                    break;
                case "2":
                    System.out.println("Enter property key: ");
                    String key = scanner.nextLine();
                    System.out.println("Enter property value: ");
                    String value = scanner.nextLine();
                    configManager.setProperty(key, value);
                    System.out.println("Property set successfully.");
                    break;
                case "3":
                    System.out.println("Enter property key to remove: ");
                    key = scanner.nextLine();
                    configManager.removeProperty(key);
                    System.out.println("Property removed successfully.");
                    break;
                case "4":
                    configManager.listProperties();
                    break;
                case "5":
                    System.out.println("Enter filename to save properties: ");
                    String saveFilename = scanner.nextLine();
                    configManager.savePropertiesToFile(saveFilename);
                    break;
                case "6":
                    System.out.println("Enter filename to load properties: ");
                    String loadFilename = scanner.nextLine();
                    configManager.loadPropertiesFromFile(loadFilename);
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Configuration Manager ---");
        System.out.println("1. Print Warehouse Location");
        System.out.println("2. Set Property");
        System.out.println("3. Remove Property");
        System.out.println("4. List Properties");
        System.out.println("5. Save Properties to File");
        System.out.println("6. Load Properties from File");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
}
