package com.state;

import java.util.Scanner;

public class VendingMachineClient {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Vending Machine ---");
            System.out.println("1. Insert Money");
            System.out.println("2. Select Product");
            System.out.println("3. Dispense Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    vendingMachine.insertMoney();
                    break;
                case 2:
                    vendingMachine.selectProduct();
                    break;
                case 3:
                    vendingMachine.dispenseProduct();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the Vending Machine. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
